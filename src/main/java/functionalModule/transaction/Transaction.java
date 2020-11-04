package functionalModule.transaction;

import javax.transaction.InvalidTransactionException;

/**
 * 转账类
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/4 14:40
 */
public class Transaction {
    private String id;
    private Long buyerId;
    private Long sellerId;
    private Long productId;
    private Long orderId;
    private Long createTimestamp;
    private Double amount;
    private STATUS status;
    private String walletTransactionId;

    private WalletRpcService walletRpcService;

    public STATUS getStatus() {
        return status;
    }

    public void setWalletRpcService(WalletRpcService walletRpcService) {
        this.walletRpcService = walletRpcService;
    }


    // ...get() methods...

    public Transaction(String preAssignedId, Long buyerId, Long sellerId, Long productId, Long orderId) {
        if (preAssignedId != null && !preAssignedId.isEmpty()) {
            this.id = preAssignedId;
        } else {
            this.id = IdGenerator.generateTransactionId();
        }

        if (!this.id.startsWith("t_")) {
            this.id = "t_" + preAssignedId;
        }

        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.orderId = orderId;
        this.status = STATUS.TO_BE_EXECUTD;
        this.createTimestamp = System.currentTimeMillis();
    }

    public boolean execute() throws InvalidTransactionException {
        if (buyerId == null || (sellerId == null || amount < 0.0)) {
            throw new InvalidTransactionException();
        }

        if (status == STATUS.EXECUTED) {
            return true;
        }

        boolean isLocked = false;
        try {
            isLocked = RedisDistributedLock.getSingletonIntance().lockTransction(id);
            if (!isLocked) {
                // 锁定未成功，返回false,job兜底执行
                return false;
            }

            //double check
            if (status == STATUS.EXECUTED) {
                return true;
            }

            long executionInvokedTimestamp = System.currentTimeMillis();
            if (executionInvokedTimestamp - createTimestamp > 14 * 60 * 60 * 1000) {
                this.status = STATUS.EXPIRED;
                return false;
            }

            String walletTransactionId = walletRpcService.moveMoney(id, buyerId, sellerId, amount);
            if (walletTransactionId != null) {
                this.walletTransactionId = walletTransactionId;
                this.status = STATUS.EXECUTED;
                return true;
            } else {
                this.status = STATUS.FAILED;
                return false;
            }
        } finally {
            if (isLocked) {
                RedisDistributedLock.getSingletonIntance().unlockTransction(id);
            }
        }
    }


    enum STATUS {
        /**
         * 被执行
         */
        TO_BE_EXECUTD,

        /**
         * 执行
         */
        EXECUTED,

        /**
         * 已过期
         */
        EXPIRED,

        /**
         * 失败
         */
        FAILED;
    }
}

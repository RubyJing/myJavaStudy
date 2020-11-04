package functionalModule.transaction;

import functionalModule.transaction.mock.MockWalletRpcServiceOne;

import javax.transaction.InvalidTransactionException;

/**
 * 单元测试
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/4 16:54
 */
public class testExecute {
    public static void main(String[] args) {
        Long buyerId = 123L;
        Long sellerId = 234L;
        Long productId = 345L;
        Long orderId = 456L;
        Transaction transaction = new Transaction(null, buyerId, sellerId, productId, orderId);
        //使用mock对象来替代真正的RPC服务
        transaction.setWalletRpcService(new MockWalletRpcServiceOne());
        try {
            boolean executedResult = transaction.execute();
            System.out.println(executedResult);
            System.out.println(transaction.getStatus());
        } catch (InvalidTransactionException e) {
            e.printStackTrace();
        }
    }
}

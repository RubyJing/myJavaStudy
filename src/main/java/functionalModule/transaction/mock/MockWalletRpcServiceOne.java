package functionalModule.transaction.mock;

import functionalModule.transaction.WalletRpcService;

/**
 * 手动mock
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/4 16:49
 */
public class MockWalletRpcServiceOne extends WalletRpcService {
    @Override
    public String moveMoney(String id, Long buyerId, Long sellerId, double amount){
        return "123bac";
    }
}

package functionalModule.transaction.mock;

import functionalModule.transaction.WalletRpcService;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/4 16:51
 */
public class MockWalletRpcServiceTwo extends WalletRpcService {
    @Override
    public String moveMoney(String id, Long buyerId, Long sellerId, double amount){
        return null;
    }
}

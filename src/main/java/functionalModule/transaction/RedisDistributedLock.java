package functionalModule.transaction;

/**
 * Redis分布式锁
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/4 15:43
 */
public class RedisDistributedLock {

    private static RedisDistributedLock instance;

    public static RedisDistributedLock getSingletonIntance() {
        if (instance == null) {
            instance = new RedisDistributedLock();
        }
        return instance;
    }

    public boolean lockTransction(String id){
        return true;
    }

    public boolean unlockTransction(String id){
        return true;
    }
}

package functionalModule.transaction;

/**
 * 事务id生成
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/4 14:56
 */
public class IdGenerator {

    private static final String APP_ID = "t_";
    private static int count = 0;

    public static String generateTransactionId() {
        count += 1;
        return APP_ID + count;
    }
}

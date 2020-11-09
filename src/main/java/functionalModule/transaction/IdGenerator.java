package functionalModule.transaction;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 事务id生成
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/4 14:56
 */
public class IdGenerator {

    private static final String APP_ID = "t_";
    private AtomicLong id = new AtomicLong(0);
    private static final IdGenerator INSTANCE = new IdGenerator();

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        return INSTANCE;
    }

    public String getId(){
        return APP_ID +id.incrementAndGet();
    }


}

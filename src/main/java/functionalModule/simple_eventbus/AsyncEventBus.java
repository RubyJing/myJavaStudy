package functionalModule.simple_eventbus;

import java.util.concurrent.Executor;

/**
 * 异步非阻塞AsyncEventBus
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/20 17:07
 */
public class AsyncEventBus  extends EventBus{

    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}

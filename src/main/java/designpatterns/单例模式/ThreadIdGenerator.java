package designpatterns.单例模式;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程唯一的单例类：id生成器
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/9 17:02
 */
public class ThreadIdGenerator {
    private AtomicLong id = new AtomicLong(0);

    private static final ConcurrentHashMap<Long,ThreadIdGenerator> INSTANCES
            = new ConcurrentHashMap<>();

    public ThreadIdGenerator() {
    }

    public static ThreadIdGenerator getInstance(){
        Long currentThreadId = Thread.currentThread().getId();
        INSTANCES.putIfAbsent(currentThreadId,new ThreadIdGenerator());
        return INSTANCES.get(currentThreadId);
    }

    public long getId(){
        return id.incrementAndGet();
    }
}

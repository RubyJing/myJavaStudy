package tips.线程例子.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger
 * @author RubyJing
 * @version 1.0
 * @date 2020/9/8 15:10
 */
public class AtomicIntegerDemo {

    private volatile int count = 0;
    public synchronized void increment(){
        count++;
    }
    public int getCount(){
        return count;
    }

    //使用AtomicInteger：不需要加锁

    private AtomicInteger atomicCount = new AtomicInteger();
    public void increment2(){
        atomicCount.incrementAndGet();
    }
    public int getCount2(){
        return atomicCount.get();
    }

}

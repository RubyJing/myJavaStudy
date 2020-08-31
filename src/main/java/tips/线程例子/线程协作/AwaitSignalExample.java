package tips.线程例子.线程协作;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * java.util.concurrent类库中提供了Condition类来实现线程之间的协调。
 * 可以在Condition上调用await()方法使线程等待，其他线程调用signal()或signalAll()方法唤醒等待的线程
 * 相比于wait()这种等待方法，await()可以指定等待的条件，因此更加灵活。
 * @author RubyJing
 * @version 1.0
 * @date 2020/8/31 9:50
 */
public class AwaitSignalExample {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void before(){
        lock.lock();
        try {
            System.out.println("before");
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void after(){
        lock.lock();
        try {
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("after");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AwaitSignalExample example = new AwaitSignalExample();
        executorService.execute(() -> example.after());
        executorService.execute(() -> example.before());
    }
}

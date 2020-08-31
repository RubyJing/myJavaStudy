package tips.线程例子.锁;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * java.util.concurrent(J.U.C)包中的锁
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/8/31 9:19
 */
public class LockExample {

    private Lock lock = new ReentrantLock();

    public void func() {
        lock.lock();
        try {
            for (int i = 0; i < 50; i++) {
                System.out.print(i + " ");
            }
        } finally {
            //确保释放锁，从而避免发生死锁
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockExample lockExample = new LockExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()-> lockExample.func());
    }
}

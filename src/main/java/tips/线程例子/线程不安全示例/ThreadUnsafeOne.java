package tips.线程例子.线程不安全示例;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程不安全示例
 * 如果多个线程对同一个共享数据进行访问而不采取同步操作的话，那么操作的结果是不一致的。
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/8/26 15:27
 */
public class ThreadUnsafeOne {
    private int cnt = 0;

    void add() {
        cnt++;
    }

    int get() {
        return cnt;
    }

    public static void main(String[] args) throws InterruptedException {
        final int threadSize = 1000;
        ThreadUnsafeOne threadUnsafeOne = new ThreadUnsafeOne();
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++) {
            executorService.execute(()->{
                threadUnsafeOne.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(threadUnsafeOne.get());
    }
}

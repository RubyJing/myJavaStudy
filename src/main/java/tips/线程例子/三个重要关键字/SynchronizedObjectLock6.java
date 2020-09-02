package tips.线程例子.三个重要关键字;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 保证可见性的原理：内存模型和happens-before规则
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/9/1 10:28
 */
public class SynchronizedObjectLock6 {

    private int a = 0;

    public synchronized void writer() {
        a++;
    }


    public synchronized void reader() {
        int i = a;
        System.out.println(i);
    }


    public static void main(String[] args) {
        SynchronizedObjectLock6 synchronizedObjectLock6 = new SynchronizedObjectLock6();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(synchronizedObjectLock6::writer);
        executorService.execute(synchronizedObjectLock6::reader);

    }


}

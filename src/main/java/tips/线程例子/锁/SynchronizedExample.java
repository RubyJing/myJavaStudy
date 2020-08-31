package tips.线程例子.锁;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * synchronized 同步锁(JVM实现）
 *
 * 它只作用于同一个对象。
 * 如果调用两个对象上的同步代码块，就不会进行同步
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/8/27 16:52
 */
public class SynchronizedExample {

    /**
     * 同步代码块
     */
    public void func() {
        synchronized (this) {
            for (int i = 0; i < 50; i++) {
                System.out.print(i + " ");
            }
        }
    }

    /**
     * 同步方法
     */
    public synchronized void func2() {
        for (int i = 0; i < 50; i++) {
            System.out.print(i + " ");
        }
    }

    /**
     * 同步类
     */
    public void func3() {
        synchronized (SynchronizedExample.class) {
            for (int i = 0; i < 50; i++) {
                System.out.println(i + "");
            }
        }
    }

    //同步静态方法
    public synchronized static void fun() {

    }


    public static void main(String[] args) {
        SynchronizedExample s1 = new SynchronizedExample();
        SynchronizedExample s2 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> s1.func2());
        executorService.execute(() -> s1.func2());

    }
}

package tips.线程例子.三个重要关键字;

/**
 * 类锁：指synchronize修饰静态的方法或指定锁对象为Class对象
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/8/31 15:24
 */
public class SynchronizedObjectLock5 implements Runnable {
    static SynchronizedObjectLock5 instance1 = new SynchronizedObjectLock5();
    static SynchronizedObjectLock5 instance2 = new SynchronizedObjectLock5();

    @Override
    public void run() {
        // 所有线程需要的锁都是同一把
        synchronized (SynchronizedObjectLock5.class) {
            System.out.println("我是线程" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "结束");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
    }
}

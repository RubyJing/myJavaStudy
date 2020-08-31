package tips.线程例子.三个重要关键字;

/**
 * 对象锁：包括方法锁（默认锁对象为this,当前实例对象）和同步代码块锁（自己指定锁对象）
 * synchronized修饰普通方法，锁对象默认为this
 * @author RubyJing
 * @version 1.0
 * @date 2020/8/31 14:54
 */
public class SynchronizedObjectLock implements Runnable {
    static SynchronizedObjectLock instance = new SynchronizedObjectLock();

    @Override
    public void run() {
        //同步代码块形式--锁为this，两个线程使用的锁是一样的。
          //线程1必须等线程0释放该锁之后，才能执行
        synchronized (this){
            System.out.println("我是线程"+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"结束");
        }
    }

    public static void main(String[] args) {
//        Runnable instance1 = new SynchronizedObjectLock();
//        Runnable instance2 = new SynchronizedObjectLock();
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();

    }
}

package tips.线程例子.三个重要关键字;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/8/31 15:10
 */
public class SynchronizedObjectLock2 implements Runnable {
    static SynchronizedObjectLock2 instance = new SynchronizedObjectLock2();

    //创建两把锁

    Object block1 = new Object();
    Object block2 = new Object();

    @Override
    public void run() {
        //这个代码使用的是第一把锁，当他释放后，后面的代码块由于使用的是第二把锁，因此可以马上执行
        synchronized (block1){
            System.out.println("block1锁，我是线程"+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("block1锁，线程"+Thread.currentThread().getName()+"结束");
        }

        synchronized (block2){
            System.out.println("block2锁，我是线程"+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("block2锁，线程"+Thread.currentThread().getName()+"结束");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
    }
}

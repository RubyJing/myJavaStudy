package tips.线程例子.concurrent;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;

/**
 * 使用part/unpark实现线程同步
 * @author RubyJing
 * @version 1.0
 * @date 2020/9/8 16:39
 */
public class LockSupportDemo2 {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2(Thread.currentThread());
        myThread2.start();
        System.out.println("before park");
        LockSupport.park("ParkAndUnParkDemo");
        System.out.println("after park");
    }

}

class MyThread2 extends Thread{
    private Object object;

    public MyThread2(Object object) {
        this.object = object;
    }

    @Override
    public void run(){
        System.out.println("before unpark");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //获取blocker
        System.out.println("Blocker info "+ LockSupport.getBlocker((Thread)object));
        //释放许可
        LockSupport.unpark((Thread)object);
        //休眠500ms，保证先执行park中的setBlocker(t,null);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Blocker info "+ LockSupport.getBlocker((Thread)object));
        System.out.println("after unpark");
    }
}

package tips.线程例子.concurrent;


/**
 * notify()/wait()实现线程同步例子
 *
 * 使用wait/notify实现同步时，必须先调用wait，后调用notify，如果先调用notify，再调用wait，将起不了作用
 * @author RubyJing
 * @version 1.0
 * @date 2020/9/8 15:39
 */
public class LockSupportDemo{


    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        synchronized (myThread){
            //主线程睡眠3s
            try {
                myThread.start();
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+" before wait");
                //阻塞主线程
                myThread.wait();
                System.out.println(Thread.currentThread().getName()+" after wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run(){
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+" before notify");
            notify();
            System.out.println(Thread.currentThread().getName()+" after notify");
        }
    }
}

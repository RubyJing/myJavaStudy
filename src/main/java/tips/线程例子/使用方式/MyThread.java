package tips.线程例子.使用方式;

/**
 * 继承Thread类
 * 当调用 start() 方法启动一个线程时，虚拟机会将该线程放入就绪队列中等待被调度，当一个线程被调度时会执行该线程的 run() 方法。
 * @author RubyJing
 * @version 1.0
 * @date 2020/8/27 16:05
 */
public class MyThread extends Thread {

    @Override
    public void run(){
        System.out.println("线程启动！");
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        //使用 setDaemon() 方法将一个线程设置为守护线程。
//        thread.setDaemon(true);
        thread.start();

    }
}

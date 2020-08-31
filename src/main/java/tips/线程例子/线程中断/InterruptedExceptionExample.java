package tips.线程例子.线程中断;

/**
 * InterruptedException线程中断例子
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/8/27 16:24
 */
public class InterruptedExceptionExample {

    private static class MyThread1 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("线程睡醒了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new MyThread1();
        thread1.start();
        thread1.interrupt();
        System.out.println("结束了");
    }
}

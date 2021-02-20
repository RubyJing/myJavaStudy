package tips.线程例子.线程中断;

/**
 * Interrupted()线程中断例子
 * 如果一个线程的run()方法执行一个无限循环，并且没有执行sleep()等会抛出 InterruptedException 的操作
 * 那么调用线程的 interrupt() 方法就无法使线程提前结束。
 *
 * 但是调用 interrupt() 方法会设置线程的中断标记，此时调用 interrupted() 方法会返回 true
 * @author RubyJing
 * @version 1.0
 * @date 2020/8/27 16:29
 */
public class InterruptedExample {

    private static class MyThread2 extends Thread{
        @Override
        public void run() {

            //实例方法isInterrupted()不清除中断标志
            if (this.isInterrupted()){
                System.out.println("已经被中断");
            }

            //静态方法interrupted()清除中断标志
            while (!interrupted()){
                System.out.println("现在执行");
            }
            System.out.println(this.isInterrupted());

            //一直执行
//            while (true){
//                System.out.println("现在执行");
//            }

            System.out.println("Thread end");
        }
    }

    public static void main(String[] args) {
        Thread thread2 = new MyThread2();
        thread2.start();
        thread2.interrupt();
    }
}

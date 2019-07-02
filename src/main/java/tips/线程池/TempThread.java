package tips.线程池;

public class TempThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"正在被执行");
        try {
            //sleep一秒保证3个任务分别在3个线程上执行
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

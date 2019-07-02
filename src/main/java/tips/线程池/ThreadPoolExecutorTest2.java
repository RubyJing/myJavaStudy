package tips.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  Executors.newFixedThreadPool(int n)：创建一个可重用固定个数的线程池，
 *  以共享的无界队列方式来运行这些线程。
 */
public class ThreadPoolExecutorTest2 {
    public static void main(String[] args) {
        //创建一个可重用固定个数的线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i=0;i<10;i++){
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        //打印正在执行的缓存线程信息
                        System.out.println(Thread.currentThread().getName()+"正在执行");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}

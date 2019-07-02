package tips.线程池;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Executors.newScheduledThreadPool(int n)：创建一个定长线程池，
 * 支持定时及周期性任务执行
 */
public class ThreadPoolExecutorTest3 {
    public static void main(String[] args) {
        //创建一个定长线程池，支持定时及周期性任务执行——延迟执行
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        //延迟1秒执行
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"延迟10秒执行");
            }
        }, 10, TimeUnit.SECONDS);

        //延迟1秒后每3秒执行一次
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"延迟1秒后每3秒执行一次");
            }
        },1,3,TimeUnit.SECONDS);
    }
}

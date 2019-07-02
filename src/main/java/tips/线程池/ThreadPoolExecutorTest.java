package tips.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  Executors.newCacheThreadPool()：可缓存线程池
 *  先查看池中有没有以前建立的线程，如果有，就直接使用，
 *  如果没有，就建一个新的线程加入池中，
 *  如果线程池大小超过了处理任务所需要的线程，会回收部分空闲的（60秒不执行任务）线程，
 *  缓存型池子通常用于执行一些生存期很短的异步型任务
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        //创建一个可缓存线程池
        ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
        for (int i = 0;i < 10;i++){
            cacheThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName()+"正在执行");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}

package tips.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  Executors.newSingleThreadExecutor()：创建一个单线程化的线程池，
 *  它只会用唯一的工作线程来执行任务，
 *  保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 */
public class ThreadPoolExecutorTest4 {
    public static void main(String[] args) {
        //创建一个单线程化的线程池
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i=1;i<10;i++){
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName()+"正在被执行,打印的值是:"+index);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}

package tips.线程池;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPoolExecutor {
    public static void main(String[] args) {
        //创建数组型缓冲等待队列
        BlockingQueue<Runnable> bq = new ArrayBlockingQueue<>(3);

        //ThreadPoolExecutor:创建自定义线程池，池中保存的线程数为3，允许最大的线程数为6
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(3,6,50, TimeUnit.MILLISECONDS,bq);
        tpe.prestartAllCoreThreads();
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
        blockingQueue.add("1");
        blockingQueue.add("2");
        blockingQueue.add("3");
        blockingQueue.add("4");
        blockingQueue.add("5");
        blockingQueue.add("6");
        blockingQueue.add("7");
        blockingQueue.add("8");
        blockingQueue.add("9");
        blockingQueue.add("10");
        //创建3个任务
        Runnable t1 = new TempThread(blockingQueue);
        Runnable t2 = new TempThread(blockingQueue);
        Runnable t3 = new TempThread(blockingQueue);
        bq.add(t1);
        bq.add(t2);
        bq.add(t3);


        //3个任务在分别在3个线程上执行
//        tpe.execute(t1);
//        tpe.execute(t2);
//        tpe.execute(t3);

        //关闭自定义连接池
        tpe.shutdown();
    }
}

package tips.线程池;

import java.util.concurrent.BlockingQueue;

public class TempThread implements Runnable {


    private BlockingQueue<String> blockingQueue;

    public TempThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (!blockingQueue.isEmpty()){
            String str = blockingQueue.poll();
            System.out.println(Thread.currentThread().getName()+"正在执行:"+str);
        }
    }
}

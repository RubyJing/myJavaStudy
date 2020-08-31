package tips.线程例子.使用方式;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现 Callable 接口
 * 与 Runnable 相比，Callable 可以有返回值，返回值通过 FutureTask 进行封装。
 * @author RubyJing
 * @version 1.0
 * @date 2020/8/27 16:01
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "线程启动成功";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
//        futureTask.run();
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }
}

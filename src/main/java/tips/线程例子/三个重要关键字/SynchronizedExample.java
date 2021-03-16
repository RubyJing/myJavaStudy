package tips.线程例子.三个重要关键字;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Synchronize同步一个代码块
 *
 * 它只作用于同一个对象，如果调用两个对象上的同步代码块，就不会进行同步。
 * @author RubyJing
 * @version 1.0
 * @date 2021/3/16 9:17
 */
public class SynchronizedExample {
    public void func1(){
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                System.out.print(i + "");
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedExample example = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        //同一对象：生效
//        executorService.execute(example::func1);
//        executorService.execute(example::func1);

        //不同对象：不生效
        SynchronizedExample example2 = new SynchronizedExample();
        executorService.execute(example::func1);
        executorService.execute(example2::func1);
    }
}

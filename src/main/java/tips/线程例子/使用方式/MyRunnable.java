package tips.线程例子.使用方式;

/**
 * 实现Runnable接口
 * 实现run()方法，通过Thread调用start()来启动线程
 * @author RubyJing
 * @version 1.0
 * @date 2020/8/27 15:56
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("线程启动了");
    }

    public static void main(String[] args) {
        MyRunnable instance = new MyRunnable();
//        instance.run();
        Thread thread = new Thread(instance);
        thread.start();
    }

}


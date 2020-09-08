package tips.线程例子.三个重要关键字;

/**
 * 保证原子性：单次读/写
 * @author RubyJing
 * @version 1.0
 * @date 2020/9/7 9:51
 */
public class VolatileTest2 {

    volatile int i;

    public void addI(){
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        final VolatileTest2 test2 = new VolatileTest2();
        for (int i = 0; i < 1000 ; i++) {
            new Thread(()->{
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test2.addI();
            }).start();
        }
        //等待10秒，保证上面的程序能够执行完成
        Thread.sleep(10000);
        System.out.println(test2.i);
    }
}

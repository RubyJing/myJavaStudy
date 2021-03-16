package tips.线程例子.线程协作;

/**
 * join()
 * 在线程中调用另一个线程的join()方法，会将当前线程挂起，而不是忙等待，直到线程结束.
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/8/31 9:30
 */
public class JoinExample {

    private class A extends Thread {
        @Override
        public void run() {
            System.out.println("A");
        }
    }

    private class B extends Thread {

        private A a;

        B(A a) {
            this.a = a;
        }

        @Override
        public void run() {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
        }
    }

    public void test() throws InterruptedException {
        A a = new A();
        B b = new B(a);
        b.start();
        a.start();
        b.join();   //这里会将主线程挂起，让b执行完
    }

    public static void main(String[] args) throws InterruptedException {
        JoinExample joinExample = new JoinExample();
        joinExample.test();
        System.out.println("线程结束了");
    }
}

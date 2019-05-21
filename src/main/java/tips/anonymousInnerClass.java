package tips;

/**
 * 匿名内部类
 * @author RubyJing
 */
public class anonymousInnerClass {
    /**
     * 抽象类的匿名内部类实现
     */
    abstract static class Person{
        public abstract void eat();
    }

    /**
     * 接口的匿名内部类实现
     */
    interface PersonTwo{
        public void eat();
    }

    public static void main(String[] args) {
        Person p = new Person() {
            @Override
            public void eat() {
                System.out.println("eat something!");
            }
        };
        p.eat();

        PersonTwo p2 = new PersonTwo() {
            public void eat() {
                System.out.println("eat something!");
            }
        };
        p2.eat();

        /**
         * Thread类的匿名内部类实现
         */
        Thread t = new Thread(){
            @Override
            public void run(){
                for (int i = 1; i <= 5; i++) {
                    System.out.print(i + " ");
                }
            }
        };
        t.start();

        /**
         * Runnable接口的匿名内部类实现
         */
        Runnable r = new Runnable() {
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.print(i + " ");
                }
            }
        };
       r.run();
    }

}

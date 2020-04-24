package tips;

/**
 * 匿名内部类
 * 匿名内部类的定义:
 * 内部类分为：静态内部类，非静态内部类。匿名内部类是非静态内部类的一种特殊情况，匿名内部类没有类名，因此就不可能有构造函数，不能创建对象。
 * 1.
 * new 实现接口（）
 * {
 *     //匿名内部类类体部分
 * }
 *
 * 2.
 * new 父类构造器（实参列表）
 * {
 *   //匿名内部类类体部分
 * }
 *
 * @author RubyJing
 */
public class AnonymousInnerClass {
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
            @Override
            public void eat() {
                System.out.println("eat something!");
            }
        };
        p2.eat();

    }

}

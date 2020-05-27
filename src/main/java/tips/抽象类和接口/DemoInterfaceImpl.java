package tips.抽象类和接口;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/5/27 11:04
 */
public class DemoInterfaceImpl implements DemoInterface {
    @Override
    public void print() {
        System.out.println("This is a function called print in son Class");
    }

    @Override
    public void print2() {
        System.out.println("This is a function called print2 in son Class");
    }
}

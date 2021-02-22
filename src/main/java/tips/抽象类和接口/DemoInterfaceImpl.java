package tips.抽象类和接口;

/**
 * 实现类支持实现多个接口
 * @author RubyJing
 * @version 1.0
 * @date 2020/5/27 11:04
 */
public class DemoInterfaceImpl implements DemoInterface,DemoInterfaceTwo {
    @Override
    public void print() {
        System.out.println("This is a function called print in son Class");
    }

    @Override
    public void print2() {
        System.out.println("This is a function called print2 in son Class");
    }

    @Override
    public String findBook(String type) {
        return null;
    }

    @Override
    public String getBook() {
        return null;
    }
}

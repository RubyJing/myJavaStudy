package tips.抽象类和接口;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/5/27 11:04
 */
public class TestInterface {


    public static void main(String[] args) {
        DemoInterface demoInterface = new DemoInterfaceImpl();
        demoInterface.print();
        //如果实现类不重写，调用的实现是接口默认的
        demoInterface.print2();
    }
}

package tips.抽象类和接口;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/5/27 11:00
 */
public interface DemoInterface {
    //默认为public的抽象方法

    void print();

    //必须定义为default的有实现的方法

    default void print2(){
        System.out.println("This is a function called print2 in dad class");
    }


    //参数只能是public，并且默认是public
    //接口的字段默认都是 static 和 final 修饰的
    int param = 2;
    public static final int param2 = 3;

}

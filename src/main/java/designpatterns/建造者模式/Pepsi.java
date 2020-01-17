package designpatterns.建造者模式;

/**
 * 百事可乐
 * @Author RubyJing
 * @Date 2020/1/17 9:12
 * @Version 1.0
 */
public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}

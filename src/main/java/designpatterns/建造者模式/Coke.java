package designpatterns.建造者模式;

/**
 * 可口可乐
 * @Author RubyJing
 * @Date 2020/1/17 9:11
 * @Version 1.0
 */
public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}

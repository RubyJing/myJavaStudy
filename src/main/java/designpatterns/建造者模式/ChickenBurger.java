package designpatterns.建造者模式;

/**
 * 鸡肉汉堡
 * @Author RubyJing
 * @Date 2020/1/17 9:10
 * @Version 1.0
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 50.5f;
    }
}

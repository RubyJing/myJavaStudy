package designpatterns.建造者模式;

/**
 * 蔬菜汉堡
 * @Author RubyJing
 * @Date 2020/1/17 9:09
 * @Version 1.0
 */
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0F;
    }
}

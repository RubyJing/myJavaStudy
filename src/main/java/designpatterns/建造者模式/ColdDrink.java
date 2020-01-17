package designpatterns.建造者模式;

/**
 *  冷饮
 * @Author RubyJing
 * @Date 2020/1/17 9:08
 * @Version 1.0
 */
public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottler();
    }

    @Override
    public abstract float price();
}

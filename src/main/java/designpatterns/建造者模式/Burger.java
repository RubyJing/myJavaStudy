package designpatterns.建造者模式;

/**
 * 汉堡
 *
 * @Author RubyJing
 * @Date 2020/1/17 9:04
 * @Version 1.0
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();

}

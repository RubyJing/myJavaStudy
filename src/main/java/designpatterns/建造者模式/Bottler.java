package designpatterns.建造者模式;

/**
 * 包装方式 --> 瓶子
 * @Author RubyJing
 * @Date 2020/1/17 9:03
 * @Version 1.0
 */
public class Bottler implements Packing {
    @Override
    public String packing() {
        return "Bottle";
    }
}

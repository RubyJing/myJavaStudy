package designpatterns.建造者模式;

/**
 * 食物条目
 * @Author RubyJing
 * @Date 2020/1/17 8:57
 * @Version 1.0
 */
public interface Item {
    String name();
    Packing packing();
    float price();
}

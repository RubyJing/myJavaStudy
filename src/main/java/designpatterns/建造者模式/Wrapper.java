package designpatterns.建造者模式;

/**
 * 包装方式-->纸盒
 * @Author RubyJing
 * @Date 2020/1/17 9:02
 * @Version 1.0
 */
public class Wrapper implements Packing {
    @Override
    public String packing() {
        return "Wrapper";
    }
}

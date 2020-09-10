package designpatterns.代理模式.exmple;

/**
 * 网球
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/9/10 16:25
 */
public class TennisBall extends AbstractSport
        implements GameBefore {
    @Override
    public void play() {
        System.out.println("打网球");
    }

}

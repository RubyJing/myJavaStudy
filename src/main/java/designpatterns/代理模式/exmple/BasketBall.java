package designpatterns.代理模式.exmple;

/**
 * 篮球
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/9/10 16:24
 */
public class BasketBall extends AbstractSport implements GameBefore,GameAfter {
    @Override
    public void play() {
        System.out.println("打篮球");
    }


}

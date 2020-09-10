package designpatterns.代理模式.exmple;

/**
 * 足球
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/9/10 16:25
 */
public class FootBall extends AbstractSport implements GameBefore {
    @Override
    public void play() {
        System.out.println("踢足球");
    }


}

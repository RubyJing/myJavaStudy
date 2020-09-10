package designpatterns.代理模式.exmple;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/9/10 16:41
 */
public class SportTest {
    public static void main(String[] args) {
        FootBall footBall = new FootBall();
        ProxySportGame proxySportGame = new ProxySportGame(footBall);
        proxySportGame.play();

        BasketBall basketBall = new BasketBall();
        ProxySportGameTwo proxySportGame2 = new ProxySportGameTwo(basketBall);
        proxySportGame2.play();

    }
}

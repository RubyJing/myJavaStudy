package designpatterns.代理模式;

/**
 * 追求控制层
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/13 11:54
 */
public class PursuitController implements IPursuitController {

    private Pursuit pursuit;

    public PursuitController(Pursuit pursuit) {
        this.pursuit = pursuit;
    }

    @Override
    public void pursuit(){
        pursuit.GiveDolls();
        pursuit.GiveChocolate();
        pursuit.GiveFlowers();
    }
}

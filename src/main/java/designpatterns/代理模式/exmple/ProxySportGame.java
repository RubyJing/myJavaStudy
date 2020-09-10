package designpatterns.代理模式.exmple;

/**
 * 代理游戏类
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/9/10 16:35
 */
public class ProxySportGame extends AbstractSport {

    protected AbstractSport abstractSport;

    public ProxySportGame(AbstractSport abstractSport) {
        this.abstractSport = abstractSport;
    }


    public void play(){
        System.out.println(abstractSport.getClass().getSimpleName());
        abstractSport.safeCheck();
        abstractSport.interview();
    }

    @Override
    public void safeCheck() {
        abstractSport.safeCheck();
    }

    @Override
    public void interview() {
        abstractSport.interview();
    }


}

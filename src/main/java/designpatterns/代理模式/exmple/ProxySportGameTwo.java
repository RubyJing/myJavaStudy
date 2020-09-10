package designpatterns.代理模式.exmple;

/**
 * 代理游戏类第二版
 * @author RubyJing
 * @version 1.0
 * @date 2020/9/10 16:55
 */
public class ProxySportGameTwo extends AbstractSport  {


    protected AbstractSport abstractSport;

    public ProxySportGameTwo(AbstractSport abstractSport) {
        this.abstractSport = abstractSport;
    }

    public void play(){
        System.out.println(abstractSport.getClass().getSimpleName());
        abstractSport.safeCheck();
        abstractSport.sayTrashTalk();
        abstractSport.interview();
    }

    @Override
    public void sayTrashTalk() {
        abstractSport.sayTrashTalk();
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

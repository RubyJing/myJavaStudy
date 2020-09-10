package designpatterns.代理模式.exmple;

/**
 * 运动抽象类
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/9/10 16:30
 */
public abstract class AbstractSport {

    public void sayTrashTalk() {
        System.out.println("垃圾话");
    }

    public void safeCheck() {
        System.out.println("赛前检查");
    }

    public void interview() {
        System.out.println("赛后采访");
    }
}

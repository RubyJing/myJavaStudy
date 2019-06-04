package designpatterns.抽象工厂模式;

/**
 * 雷锋工厂
 */
public class UndergraduateFactory implements IFactory {
    @Override
    public LeiFeng CreateLeiFeng() {
        return new Undergraduate();
    }
}

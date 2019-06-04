package designpatterns.抽象工厂模式;

/**
 * 社区志愿者工厂
 */
public class VolunteerFactory implements IFactory {
    @Override
    public LeiFeng CreateLeiFeng() {
        return new Volunteer();
    }
}

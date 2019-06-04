package designpatterns.抽象工厂模式;

/**
 * 社区志愿者
 */
public class Volunteer implements LeiFeng {
    @Override
    public void Sweep() {
        System.out.println("扫地");
    }

    @Override
    public void Wash() {
        System.out.println("洗衣");
    }

    @Override
    public void BuyRice() {
        System.out.println("买米");
    }
}

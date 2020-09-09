package designpatterns.装饰模式.example;

/**
 * 刀
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/9/9 15:48
 */
public class Knife extends AbstractWeapon {

    public Knife() {
    }

    @Override
    String weaponName() {
        return "刀";
    }

    @Override
    void thorn() {
        System.out.println("刺");
    }

    @Override
    public void hack() {
        System.out.println("劈");
    }
}

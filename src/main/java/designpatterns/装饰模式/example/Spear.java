package designpatterns.装饰模式.example;

/**
 * 矛
 * @author RubyJing
 * @version 1.0
 * @date 2020/9/9 15:52
 */
public class Spear extends AbstractWeapon {


    @Override
    String weaponName() {
        return "矛";
    }

    @Override
    public void thorn() throws NullPointerException {
        System.out.println("刺");
    }

}

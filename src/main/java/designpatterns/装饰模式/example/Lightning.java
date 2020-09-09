package designpatterns.装饰模式.example;

/**
 * 闪电
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/9/9 16:50
 */
public class Lightning extends FilterWeaponMagic {

    public Lightning(AbstractWeapon abstractWeapon) {
        super(abstractWeapon);
    }

    @Override
    public void thorn() {
        System.out.print("闪电");
        abstractWeapon.thorn();
    }

    @Override
    String weaponName() {
        System.out.print("闪电");
        return abstractWeapon.weaponName();
    }
}

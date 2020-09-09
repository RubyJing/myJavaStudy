package designpatterns.装饰模式.example;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/9/9 17:17
 */
public class Austerity extends FilterWeaponMagic {
    public Austerity(AbstractWeapon abstractWeapon) {
        super(abstractWeapon);
    }

    @Override
    public void thorn() {
        System.out.print("冰霜");
        abstractWeapon.thorn();
    }

    @Override
    String weaponName() {
        System.out.print("冰霜");
        return abstractWeapon.weaponName();
    }
}

package designpatterns.装饰模式.example;

/**
 * 火焰
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/9/9 15:57
 */
public class Flame extends FilterWeaponMagic {

    public Flame(AbstractWeapon abstractWeapon) {
        super(abstractWeapon);
    }

    @Override
    String weaponName() {
        System.out.print("火焰");
        return abstractWeapon.weaponName();
    }

    @Override
    public String getMagicName() {
        return "火焰";
    }

    @Override
    public void hack() {
        System.out.print("火焰");
        abstractWeapon.hack();
    }

    @Override
    public void thorn(){
        System.out.print("火焰");
        abstractWeapon.thorn();
    }




}

package designpatterns.装饰模式.example;

/**
 * 武器魔法包装类
 * @author RubyJing
 * @version 1.0
 * @date 2020/9/9 15:54
 */
public class FilterWeaponMagic extends AbstractWeapon
        implements Magic {

    protected AbstractWeapon abstractWeapon;

    public FilterWeaponMagic(AbstractWeapon abstractWeapon) {
        this.abstractWeapon = abstractWeapon;
    }


    @Override
    String weaponName() {
       return abstractWeapon.weaponName();
    }

    @Override
    void thorn() {
        abstractWeapon.thorn();
    }


    @Override
    public String getMagicName() {
        throw new NullPointerException();
    }


}

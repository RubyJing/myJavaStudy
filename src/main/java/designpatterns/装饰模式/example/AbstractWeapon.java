package designpatterns.装饰模式.example;

/**
 * 武器
 * @author RubyJing
 * @version 1.0
 * @date 2020/9/9 16:23
 */
public abstract class AbstractWeapon {

    abstract String weaponName();

    abstract void thorn();

    protected void hack(){};
}

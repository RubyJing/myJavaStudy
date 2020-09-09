package designpatterns.装饰模式.example;

/**
 * 剑
 * @author RubyJing
 * @version 1.0
 * @date 2020/9/9 15:50
 */
public class Sword extends AbstractWeapon {

    public Sword() {

    }

    @Override
    String weaponName() {
        return "剑";
    }

    @Override
    public void thorn() throws NullPointerException {
        System.out.println("刺");
    }

    @Override
    public void hack(){
        System.out.println("劈");
    }

}

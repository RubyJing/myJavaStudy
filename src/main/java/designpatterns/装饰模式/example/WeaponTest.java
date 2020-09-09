package designpatterns.装饰模式.example;

import tips.注解.A;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/9/9 15:57
 */
public class WeaponTest {
    public static void main(String[] args) {
        //闪电火焰冰霜剑
        Sword sword = new Sword();
        Austerity austerity = new Austerity(sword);
        Flame flame = new Flame(austerity);
        Lightning lightning = new Lightning(flame);
        System.out.println(lightning.weaponName());
    }
}

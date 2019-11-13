package tips.枚举;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

/**
 * 使用接口组织枚举
 * @Author RubyJing
 * @Date 2019/11/13 13:51
 * @Version 1.0
 */
public class GroupEnumInterface {
    //枚举集合java.util.EnumSet和java.util.EnumMap是两个枚举集合
    //EnumSet保证集合中的元素不重复；EnumMap中的 key是enum类型，而value则可以是任意类型。

    public static void main(String[] args) {
        EnumSet<Constant> constantEnumSet = EnumSet.allOf(Constant.class);
        System.out.println(constantEnumSet);
        EnumMap<Constant,String> map = new EnumMap<>(Constant.class);
        map.put(Constant.MONDAY,"做操");
        map.put(Constant.TUESDAY,"玩");
        System.out.println(map);
    }




}

interface Food{
    enum Coffee implements Food{
        BLACK_COFFEE,DECAF_COFFEE,LATTE,CAPPUCCINO
    }
    enum Dessert implements Food{
        FRUIT, CAKE, GELATO
    }
}

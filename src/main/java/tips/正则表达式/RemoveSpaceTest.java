package tips.正则表达式;

/**
 * 去除空格练习
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/7/29 15:00
 */
public class RemoveSpaceTest {
    public static void main(String[] args) {
        String abc = "  XXX  ZZZ  ";
        System.out.println(abc + "|");
        //去除左空格
        System.out.println(removeLeft(abc) + "|");
        //去除右空格
        System.out.println(removeRight(abc) + "|");
        //去除两边空格
        System.out.println(abc.trim());
        //去除所有空格
        System.out.println(removeAll(abc));
    }

    public static String removeLeft(String value) {
        String regular = "^[ ]+";
        return value.replaceFirst(regular, "");
    }

    public static String removeRight(String value) {
        String regular = "[ ]+$";
        return value.replaceFirst(regular, "");
    }

    public static String removeAll(String value) {
        return  value.replaceAll(" ","");
    }

}

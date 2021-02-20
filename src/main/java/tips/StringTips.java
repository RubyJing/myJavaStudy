package tips;

/**
 * String的注意细节
 *
 *    直接定义的“hel"是字符串常量，在编译器就被确定了，被缓存到String常量池；
 *    而new String()创建的字符串不是常量，不能在编译器确定，所以不会被缓存到String常量池中，有自己的地址空间。
 *   另外加餐：String.intern()方法
 *        存在于.class文件中的常量池，在运行期被JVM装载，并且可以扩充。
 *        String的intern()方法就是扩充常量池的一个方法；
 *        当一个String实例str调用intern()方法时，Java查找常量池中是否有相同Unicode的字符串常量，如果有，则返回其引用，
 *     如果没有，则在常量池中增加一个Unicode等于str的字符串并返回它的引用。
 * @author RubyJing
 * @version 1.0
 * @date 2021/2/20 13:59
 */
public class StringTips {
    public static void main(String[] args) {
        String hello2 = "hello";
        String hello = new String("hello");
        String hello3 = "he" + "llo";
        String hello4 = "he" + new String("llo");
        System.out.println(hello == hello2);
        System.out.println(hello.intern() == hello2);
        System.out.println(hello3 == hello2);
        System.out.println(hello4 == hello2);
    }
}

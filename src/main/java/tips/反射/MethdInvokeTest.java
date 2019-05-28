package tips.反射;

import java.lang.reflect.Method;

/**
 * 通过反射调用对象的方法
 */
public class MethdInvokeTest {
    public static void main(String[] args) throws Exception{
        String str = "hello";
        Method m = str.getClass().getMethod("toUpperCase");
        System.out.println(m.invoke(str));
    }
}

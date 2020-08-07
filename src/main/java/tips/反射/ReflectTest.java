package tips.反射;

import java.lang.reflect.Field;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/8/6 13:56
 */
public class ReflectTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<Dog> dogClass = Dog.class;

        //类名打印
        System.out.println(dogClass.getName());
        System.out.println(dogClass.getSimpleName());
        System.out.println(dogClass.getCanonicalName());

        //接口
        System.out.println(dogClass.isInterface());
        for (Class<?> anInterface : dogClass.getInterfaces()) {
            System.out.println(anInterface);
        }
        //interface tips.反射.I1
        //interface tips.反射.I2

        //父类
        System.out.println(dogClass.getSuperclass());
        //创建对象
        Dog dog = dogClass.newInstance();
        //字段
        for (Field field : dogClass.getFields()) {
            System.out.println(field.getName());
        }
        System.out.println("-----------------------------");
        for (Field declaredField : dogClass.getDeclaredFields()) {
            System.out.println(declaredField);
        }
    }
}

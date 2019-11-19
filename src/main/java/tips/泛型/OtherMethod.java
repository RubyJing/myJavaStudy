package tips.泛型;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型方法的其他情况
 * @Author RubyJing
 * @Date 2019/11/18 15:17
 * @Version 1.0
 */
public class OtherMethod {

    public static void main(String[] args) {
        printMsg("111",222,"好好",123.45,"xixi".length());

        Nomal<String> stringNomal = new Nomal<>("1111");
        Nomal<Integer> integerNomal = new Nomal<>(22);
        showKeyValue(integerNomal);
        //编译错误，因为String不是Number的子类型
//        showKeyValue(stringNomal);
//        showKeyName(stringNomal);

        /**
         * 泛型数组
         */
        //不能创建一个确切的泛型类型的数组(以下编译报错)
     //   List<String>[] ls = new ArrayList<String>[10];
        //使用通配符可以
        List<?>[] ls = new ArrayList<?>[10];
        List<String>[] ls2 = new ArrayList[10];
    }

    /**
     * 泛型方法和可变参数的例子
     * 注意：如果静态方法使用泛型的话，必须将静态方法定义成泛型方法
     * @param args
     * @param <T>
     */
    public static <T> void printMsg(T... args){
        for (T t : args){
            System.out.println("泛型测试：t is "+t);
        }
    }

    /**
     * 泛型的上下边界：传入的类型实参必须是指定类型的子类型
     * @param obj
     */
    public static void showKeyValue(Nomal<? extends Number> obj){
        System.out.println("泛型测试：key is "+obj.getKey());
    }

    //在泛型方法中添加上下边界限制的时候，
    // 必须在权限声明与返回值之间的<T>上添加上下边界
    //即在泛型声明的时候添加

    public static <T extends Number> T showKeyName(Nomal<T> obj){
        System.out.println("泛型测试：key is "+obj.getKey());
        T test = obj.getKey();
        return test;
    }


}

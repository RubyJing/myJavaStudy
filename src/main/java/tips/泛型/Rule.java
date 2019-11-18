package tips.泛型;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author RubyJing
 * @Date 2019/11/13 16:00
 * @Version 1.0
 */
public class Rule {

    /**
     * 泛型只在编译阶段有效，在运行阶段会去泛型化
     * -->泛型类型在逻辑上看以看成是多个不同的类型，实际上都是相同的基本类型
     * @param args
     */
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        Class stringListClass = stringList.getClass();
        Class integerListClass = integerList.getClass();
        //true
        System.out.println(stringListClass.equals(integerListClass));
    }
}

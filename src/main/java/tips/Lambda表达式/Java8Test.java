package tips.Lambda表达式;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java8Test {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu ");
        names.add("Sina ");

        List<String> names2 = new ArrayList<>();
        names2.add("Google2");
        names2.add("Runoob2");
        names2.add("Taobao2");
        names2.add("Baidu ");
        names2.add("Sina ");

        Java8Test test = new Java8Test();
        System.out.println("使用Java7语法");
        test.sortUsingJava7(names);
        System.out.println(names);

        System.out.println("使用Java8语法");
        test.sortUsingJava8(names2);
        System.out.println(names2);

    }

    //使用java7排序
    private void sortUsingJava7(List<String> names){
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //正序
                return o2.compareTo(o1);
            }
        });
    }

    //使用java8排序
    private void sortUsingJava8(List<String> names){
        //倒序
        Collections.sort(names,(s1,s2) -> s1.compareTo(s2));
    }
}

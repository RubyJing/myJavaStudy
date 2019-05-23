package tips.TreeMap和TreeSet和Collections.sort方法排序;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        /**
         * TreeSet的例子
         */
        // Java 7的钻石语法(构造器后面的尖括号中不需要写类型)
        Set<Student> set = new TreeSet<>();
        set.add(new Student("RubyJing",24));
        set.add(new Student("XiaoFng",18));
        set.add(new Student("XiaoCai",20));
        for (Student stu : set){
            System.out.println("TreeSet："+stu);
        }

        /**
         * TreeMap的例子
         */
        Map<Student,String> map = new TreeMap<>();
        map.put(new Student("RubyJing",27),"测试1");
        map.put(new Student("RubyJing2",23),"测试2");
        map.put(new Student("RubyJing3",30),"测试3");
        map.put(new Student("RubyJing4",18),"测试4");
        Set<Student> set2 = map.keySet();
        Iterator<Student> iterator = set2.iterator();
        while (iterator.hasNext()){
            Student key = iterator.next();
            System.out.println("TreeMap："+key);
            String value = map.get(key);
            System.out.println("value："+value);
        }
        /**
         * Collections.sort的例子
         */
        List<Student2> list = new ArrayList<>();
        list.add(new Student2("RubyJing",24));
        list.add(new Student2("XiaoFng",18));
        list.add(new Student2("XiaoCai",20));
        // 通过sort方法的第二个参数传入一个Comparator接口对象
        // 相当于是传入一个比较对象大小的算法到sort方法中
        // 由于Java中没有函数指针、仿函数、委托这样的概念
        // 因此要将一个算法传入一个方法中唯一的选择就是通过接口回调

        Collections.sort(list, new Comparator<Student2>() {
            @Override
            public int compare(Student2 o1, Student2 o2) {
                //倒序，从大到小
               return o1.getName().compareTo(o2.getName());
              //  return o2.getAge()-o1.getAge(); //
            }
        });
        for (Student2 stu : list){
            System.out.println(stu);
        }
    }
}

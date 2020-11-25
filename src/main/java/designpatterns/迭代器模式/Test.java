package designpatterns.迭代器模式;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/25 9:12
 */
public class Test {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("xzg");
        names.add("wang");
        names.add("zzz");

        //自定义迭代器实现
//        MyIterator<String> myIterator = new LinkedIterator(names);
//        while (myIterator.hasNext()){
//            System.out.println(iterator.currentItem());
//            myIterator.next();
//        }

        //未决问题（在迭代时，修改或新增容器元素），java校验后会报错。
//        Iterator<String> iterator = names.iterator();
//        iterator.next();
//        names.remove("wang");
//        iterator.next();//java校验后会报错IllegalStateException

        //并发情况
//        Iterator iterator1 = names.iterator();
//        Iterator iterator2 = names.iterator();
//        iterator1.next();
//        iterator1.remove();
//        iterator2.next(); // 运行结果：报错ConcurrentModificationException
    }
}

package tips.线程例子.三个重要关键字;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * final域重排序规则
 *
 * 写final域重排序规则：在对象引用为任意线程可见之前，对象的final域已经被正确初始化过了
 * 读final域重排序规则：在读一个对象的final域之前，一定会先读这个包含final域的对象的引用
 * @author RubyJing
 * @version 1.0
 * @date 2020/9/8 9:53
 */
public class FinalDemo {

    private int a;  // 普通域
    private final int b;  // final域
    private static FinalDemo finalDemo;

    public FinalDemo() {
        a = 1;  // 写普通域
        b = 2;  // 写final域
    }

    public static void writer(){
        finalDemo = new FinalDemo();
    }

    public static void reader(){
        FinalDemo demo = finalDemo; //读对象引用
        int a = demo.a; // 读普通域
        int b = demo.b; // 读final域
        System.out.println(a);
        System.out.println(b);
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(FinalDemo::writer);
        executorService.execute(FinalDemo::reader);
    }
}

package tips.线程例子.共享数据;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 相对线程安全
 * 需要保证对这个对象单独的操作是线程安全的，在调用的适合不需要做二外的保障措施。
 * 但是对于一些特定顺序的连续调用，就可能需要在调用端使用额外的同步手段来保证调用的正确性。
 * 例如 Vector、HashTable、Collections 的 synchronizedCollection() 方法包装的集合等
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/8/27 15:08
 */
public class RelativelySafe {


}

class VectorUnsafeExample {
    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 100; i++) {
                vector.add(i);
            }
            ExecutorService executorService = Executors.newCachedThreadPool();
//            executorService.execute(() -> {
//                for (int i = 0; i < vector.size(); i++) {
//                    vector.remove(i);
//                }
//            });
//            executorService.execute(() -> {
//                for (int i = 0; i < vector.size(); i++) {
//                    vector.get(i);
//                }
//            });
            executorService.execute(() -> {
                synchronized (vector) {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }

            });
            executorService.execute(() -> {
                synchronized (vector) {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.get(i);
                    }
                }
            });
            executorService.shutdown();
        }
    }
}


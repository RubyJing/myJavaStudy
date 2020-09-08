package tips.线程例子.三个重要关键字;

/**
 * 单例--双重检查（double-checked)
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/9/7 8:51
 */
public class SingletonVolatile {

    public static volatile SingletonVolatile singleton;

    private SingletonVolatile() {
    }

    public static SingletonVolatile getInstance() {
        if (singleton == null) {
            synchronized (SingletonVolatile.class) {
                if (singleton == null) {
                    singleton = new SingletonVolatile();
                }
            }
        }
        return singleton;
    }

}



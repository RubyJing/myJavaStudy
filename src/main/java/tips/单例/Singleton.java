package tips.单例;

/**
 * 饿汉式单例
 */
public class Singleton {
    private Singleton(){}
    private static Singleton instance = new Singleton();
    public static Singleton getInstance(){
        return instance;
    }
}

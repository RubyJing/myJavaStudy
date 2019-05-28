package tips.单例;

/**
 * 懒汉式单例
 */
public class Singleton2 {
    private static Singleton2 instance = null;
    private Singleton2(){}
    public static synchronized Singleton2 getInstance(){
        if(instance==null){
            instance = new Singleton2();
        }
        return instance;
    }
}

package designpatterns.单例模式;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 不同日志生成实例：多例（按照类型生成）
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/10 11:39
 */
public class Logger {

    private static final ConcurrentHashMap<String,Logger> INSTANCES
            = new ConcurrentHashMap<>();

    private Logger() {
    }

    public static Logger getInstance(String logName){
        INSTANCES.putIfAbsent(logName,new Logger());
        return INSTANCES.get(logName);
    }

    public void log(){
        System.out.println(this);
    }

    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance("User.class");
        Logger logger2 = Logger.getInstance("Order.class");
        Logger logger3 = Logger.getInstance("User.class");
        System.out.println(logger1 == logger2);
        System.out.println(logger1 == logger3);
        logger1.log();
        logger2.log();
        logger3.log();
    }
}



package designpatterns.责任链模式;

/**
 * 控制台打印
 * @author RubyJing
 * @version 1.0
 * @date 2020/9/24 15:27
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger:"+message);
    }
}

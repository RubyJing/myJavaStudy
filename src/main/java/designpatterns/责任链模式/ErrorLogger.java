package designpatterns.责任链模式;

/**
 * 错误打印
 * @author RubyJing
 * @version 1.0
 * @date 2020/9/24 15:29
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger:"+message);
    }
}

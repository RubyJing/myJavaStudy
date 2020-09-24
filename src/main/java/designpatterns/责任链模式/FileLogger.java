package designpatterns.责任链模式;

/**
 * 文件打印
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/9/24 15:30
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int lever) {
        this.level = lever;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger:" + message);
    }
}

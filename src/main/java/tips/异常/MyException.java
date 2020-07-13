package tips.异常;

/**
 * 自定义异常
 * @author RubyJing
 * @version 1.0
 * @date 2020/7/13 15:42
 */
public class MyException extends Exception{

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}

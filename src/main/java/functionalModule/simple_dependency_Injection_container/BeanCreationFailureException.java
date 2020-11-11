package functionalModule.simple_dependency_Injection_container;

/**
 * Bean创建失败异常
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/11 11:48
 */
public class BeanCreationFailureException extends Exception {

    public BeanCreationFailureException() {
    }

    public BeanCreationFailureException(String message) {
        super(message);
    }

    public BeanCreationFailureException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeanCreationFailureException(Throwable cause) {
        super(cause);
    }

    public BeanCreationFailureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

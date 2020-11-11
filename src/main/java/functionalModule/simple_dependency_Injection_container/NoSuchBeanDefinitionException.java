package functionalModule.simple_dependency_Injection_container;

/**
 * 没有此类Bean定义的异常
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/11 11:24
 */
public class NoSuchBeanDefinitionException extends Exception{

    public NoSuchBeanDefinitionException() {
    }

    public NoSuchBeanDefinitionException(String message) {
        super(message);
    }

    public NoSuchBeanDefinitionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchBeanDefinitionException(Throwable cause) {
        super(cause);
    }

    public NoSuchBeanDefinitionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

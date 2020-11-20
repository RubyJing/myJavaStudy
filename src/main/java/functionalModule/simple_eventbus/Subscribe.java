package functionalModule.simple_eventbus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 订阅
 * 用于标明观察者中的哪个函数可以接收消息
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/20 15:48
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Subscribe {
}

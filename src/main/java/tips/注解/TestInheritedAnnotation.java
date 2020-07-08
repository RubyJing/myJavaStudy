package tips.注解;

import java.lang.annotation.*;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/7/8 14:35
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface TestInheritedAnnotation {
    String[] values();
    int number();
}

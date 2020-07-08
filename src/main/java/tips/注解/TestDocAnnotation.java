package tips.注解;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/7/8 13:56
 */
@Documented
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface TestDocAnnotation {

    public String value() default "default";
}

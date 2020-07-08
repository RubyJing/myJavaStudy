package tips.注解;

import java.util.ArrayList;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/7/8 16:19
 */
public class TypeParametetAndTypeUseAnnotation<@MyNotEmpty T> {

    //使用TYPE_PARAMETER类型，会编译不通过
//    public @MyNotEmpty T test(@MyNotEmpty T a){
//        new ArrayList<@MyNotEmpty String>();
//        return a;
//    }
//
    public @MyNotNull T test2(@MyNotNull T a){
        new ArrayList<@MyNotNull String>();
        return a;
    }
}

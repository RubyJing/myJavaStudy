package tips.线程例子.共享数据;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 不可变的数据:
 * final修饰;String;
 * Number部分子类：Long和Double这类数值包装类型；BigInteger和BigDecimal等大数据类型
 * 集合：使用Collections.unmodifiable集合类型（）;
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/8/27 15:01
 */
public class Immutable {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(map);
        unmodifiableMap.put("a",1);
    }
}

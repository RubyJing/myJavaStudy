package tips;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * map的两种遍历方式
 * @RubyJing
 */
public class mapIterator {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("1",1);;
        map.put("2",2);
        /**
         * 先获取key,再通过key获取value
         * map.keySet()获取key组
         */
        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            String key = it.next();
            Object value = map.get(key);
            System.out.println("key="+key);
            System.out.println("value="+value);
        }

        /**
         * 获取key和value的映射关系，再从中获取对应的key和value
         *
         */
        Set<Map.Entry<String,Object>> entries = map.entrySet();
        for (Map.Entry<String,Object> entry:entries){
            String key2 = entry.getKey();
            Object value2 = entry.getValue();
            System.out.println("key2="+key2);
            System.out.println("value2="+value2);
        }
    }
}

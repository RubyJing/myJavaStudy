package tips.注解;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/7/8 11:26
 */
public class A {
    public void test(){

    }
}

class B extends A{

    /**
     * 重载父类的test方法
     */
    @Override
    public void test() {
        super.test();
    }

    /**
     * 被弃用的方法
     */
    @Deprecated
    public void oldMethod(){

    }

    /**
     * 忽略告警
     */
    @SuppressWarnings("rawtypes")
    public List processList(){
        List list = new ArrayList();
        return list;
    }
}

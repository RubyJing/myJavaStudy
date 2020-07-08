package tips.泛型;

import java.util.Date;

/**
 * 泛型的桥接方法
 * 类型擦除会造成多态的冲突，而JVM解决方法就是桥接方法
 * @author RubyJing
 * @version 1.0
 * @date 2020/7/7 16:02
 */
public class GenericBridgeMethod {
    public static void main(String[] args) {
        DateInter dateInter = new DateInter();
        dateInter.setValue(new Date());
//        dateInter.setValue(new Object()); 编译错误
    }

}

class Pair<T>{
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

class DateInter extends Pair<Date>{

    @Override
    public Date getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(Date value) {
        super.setValue(value);
    }
}
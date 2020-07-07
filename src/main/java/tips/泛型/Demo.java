package tips.泛型;

import java.util.Iterator;
import java.util.List;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/7/7 10:26
 */
public class Demo {

    public static void main(String[] args) {
        discount(new Me());
    }


    // 工资低于2500元的上班族并且站立的乘客车票打8折
    public static <T extends Passenger & Staff> void discount(T t) {
        if (t.getSalary() < 2500 && t.isStanding()) {
            System.out.println("恭喜你！您的车票打八折！");
        }
    }

    /**
     * 上述代码中的类型参数 E 的范围是<E extends Comparable<? super E>>，
     * 我们可以分步查看： 要进行比较，所以 E 需要是可比较的类，
     * 因此需要 extends Comparable<…>（注意这里不要和继承的 extends 搞混了，不一样） Comparable< ? super E> 要对 E 进行比较，即 E 的消费者，所以需要用 super 而参数 List< ? extends E> 表示要操作的数据是 E 的子类的列表，指定上限，这样容器才够大
     */
    private <E extends Comparable<? super E>> E max(List<? extends E> e1) {
        if (e1 == null) {
            return null;
        }
        Iterator<? extends E> iterator = e1.iterator();
        E result = iterator.next();
        while (iterator.hasNext()) {
            E next = iterator.next();
            if (next.compareTo(result) > 0) {
                result = next;
            }
        }
        return result;
    }

}

interface Passenger {
    int getSalary();
}

interface Staff {
    boolean isStanding();
}

class Me implements Passenger, Staff {

    @Override
    public int getSalary() {
        return 1500;
    }

    @Override
    public boolean isStanding() {
        return true;
    }
}
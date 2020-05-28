package tips;

/**
 * equals方法的实现
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/5/28 15:18
 */
public class EqualExample implements Cloneable{
    private int x;
    private int y;
    private int z;

    public EqualExample(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        //是否为同一引用，是直接返回true
        if (this == o) {
            return true;
        }
        //为null和不是同一类型返回false
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EqualExample that = (EqualExample) o;
        //判断值，只要有个值不相等，返回false
        if (x != that.x) {
            return false;
        }
        if (y != that.y) {
            return false;
        }
        return z == that.z;
    }

    @Override
    public int hashCode(){
        int result = 17;
        result = 31 * result + x;
        result = 31 * result + y;
        result = 31 * result + z;
        return result;
    }

    @Override
    public EqualExample clone() throws CloneNotSupportedException {
        return (EqualExample)super.clone();
    }
}

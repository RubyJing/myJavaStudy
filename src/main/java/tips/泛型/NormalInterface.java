package tips.泛型;

/**
 * 一个简单的泛型接口示例
 *
 * @Author RubyJing
 * @Date 2019/11/18 11:41
 * @Version 1.0
 */
public interface NormalInterface<T> {
     T next();
}

/**
 *未传入泛型实参时：
 * 与泛型类的定义相同，
 * 在声明类的时候，需将泛型的声明也一起加到类中
 * @param
 */
class NormalInterfaceImpl<T> implements NormalInterface<T>{

    @Override
    public T next() {
        return null;
    }
}

/**
 * 传入泛型实参时：
 * 定义一个生产器实现这个接口，虽然我们只创建了一个泛型接口NormalInterface<T>
 *  但是我们可以为T传入无数个实参，形成无数种类型的NormalInterface接口。
 *  在实现类实现泛型接口时，如已将泛型类型传入实参类型，则所有使用泛型的地方都要替换成传入的实参
 */
class NormalInterface2Impl implements NormalInterface<String>{

    @Override
    public String next() {
        return null;
    }
}
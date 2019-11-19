package tips.泛型;

/**
 * 泛型方法的普通示例
 * @Author RubyJing
 * @Date 2019/11/18 14:14
 * @Version 1.0
 */
public class NomalMethod {

    /**
     * 泛型方法的基本介绍
     * @param tClass 传入的泛型实参
     * @return <T> 返回值为T类型
     * @throws IllegalAccessException
     * @throws InstantiationException
     * 说明：
     *   1.public 与返回值中间的<T>非常重要，可以理解为声明此方法为泛型方法
     *   2. 只有声明了<T> 的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法
     *   3. <T> 表明该方法将使用泛型类型T,此时才可以在方法中使用泛型类型T
     *   4.与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T,E,K,V等形式的参数常用于表示泛型
     */
    public <T> T genericMethod(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        T instance = tClass.newInstance();
        return instance;
    }

    //======================以下是一个简单的例子说明=========================

    //这个类是个泛型类

    public class  Normal<T>{
        private T key;

        public Normal(T key) {
            this.key = key;
        }

        //虽然方法中使用了泛型，但是这并不是一个泛型方法
        //这只是类中一个普通的成员方法，只不过他的返回值是在声明泛型类已经声明过的泛型，
        //所以在这个方法中才可以继续使用T这个泛型
        public T getKey() {
            return key;
        }

        //这个方法显然有问题，编译器会提示我们无法解析符号E
//        public E getKey(){
//            return key;
//        }

        //这才是一个真正的泛型方法
//        public <K,T> K showKeyName(Nomal<T> nomal){
//            ...
//        }

        //不是正确的使用格式，只是为了说明特性
        public <T> T showKeyName(Nomal<T> nomal){
            T test = nomal.getKey();
            return test;
        }
    }
}



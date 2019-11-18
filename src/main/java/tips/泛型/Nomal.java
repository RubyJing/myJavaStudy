package tips.泛型;

/**
 * 泛型类的一个基本示例
 *
 * 此处T可以随便写为任意标识，常见的如T,E,K,V等形式的参数常用于标识泛型
 * 在实例化泛型类的时候，必须指定T的具体类型
 * @Author RubyJing
 * @Date 2019/11/18 11:26
 * @Version 1.0
 */
public class Nomal<T> {

    private T key;

    public Nomal(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }
}

class Test{
    //定义的泛型类，不一定要传入泛型类型实参。
    //传入实参会对参数进行限制
    public static void main(String[] args) {
        Nomal<Integer> integerNomal = new Nomal<>(123456);
        Nomal<String> stringNomal = new Nomal<>("key_value");
        System.out.println("泛型测试，key is "+integerNomal.getKey());
        System.out.println("泛型测试，key is "+stringNomal.getKey());

        Nomal nomal = new Nomal("111");
        Nomal nomal2 = new Nomal(111);
        Nomal nomal3 = new Nomal(33.33);
        System.out.println("泛型测试，key is "+nomal.getKey());
        System.out.println("泛型测试，key is "+nomal2.getKey());
        System.out.println("泛型测试，key is "+nomal3.getKey());

        //注意事项：
        //1.泛型的类型参数只能是类类型，不能是简单类型
        //2.不能对确切的泛型类型使用instanceof操作，编译会报错.如下
//        if (integerNomal instanceof Nomal<Integer>){
//
//        }
    }



}

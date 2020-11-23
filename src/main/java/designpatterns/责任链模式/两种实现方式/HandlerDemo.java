package designpatterns.责任链模式.两种实现方式;

/**
 * 责任链基本Demo：如果处理器链上的某个处理器能够处理这个请求，那就不会继续往下传递请求
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/23 16:04
 */
public class HandlerDemo {
    public static void main(String[] args) {
        //方式一：链条数据结构，使用抽象类继承实现
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());
        chain.handle();
        //方式二：数组结构，使用接口实现
        HandlerChain2 chain2 = new HandlerChain2();
        chain2.addHandler(new HandlerA());
        chain2.addHandler(new HandlerB());
        chain2.handle();
    }
}

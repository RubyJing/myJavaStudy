package designpatterns.观察者模式;

/**
 * 观察者一具体实现
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/20 14:23
 */
public class ConcreteObserverTwo implements Observer {
    @Override
    public void update(Message message) {
        //获取到消息通知，执行自己的逻辑
        System.out.println("ConcreteObserverTwo is notified");
    }
}

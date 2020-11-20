package designpatterns.观察者模式;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/20 14:23
 */
public class ObserverTest {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.registerObserver(new ConcreteObserverOne());
        subject.registerObserver(new ConcreteObserverTwo());
        subject.notifyObservers(new Message());
    }
}

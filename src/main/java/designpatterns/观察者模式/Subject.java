package designpatterns.观察者模式;

/**
 * 被观察者
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/20 14:16
 */
public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(Message message);
}

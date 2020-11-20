package designpatterns.观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体主题
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/20 14:19
 */
public class ConcreteSubject implements Subject {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Message message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

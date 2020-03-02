package designpatterns.观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/3/2 13:52
 */
public class Subject {

    private List<AbstractObserver> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        notifyAllObservers(state);
    }

    //订阅
    public void addAttach(AbstractObserver observer){
        observers.add(observer);
    }

    /**
     *    通知所有订阅的观察者
     */
    private void notifyAllObservers(int state){
        for (AbstractObserver observer : observers) {
            observer.update(state);
        }
    }
}

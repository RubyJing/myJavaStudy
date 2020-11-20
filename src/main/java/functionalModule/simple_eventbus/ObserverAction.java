package functionalModule.simple_eventbus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 观察员行动
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/20 15:50
 */
public class ObserverAction {
    private Object target;
    private Method method;

    public ObserverAction(Object target, Method method) {
        if (target == null) {
            throw new NullPointerException();
        }
        this.target = target;
        this.method = method;
        this.method.setAccessible(true);
    }

    public void execute(Object event) { //event是 method方法的参数
        try {
            method.invoke(target, event);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

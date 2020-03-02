package designpatterns.观察者模式;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/3/2 14:45
 */
public class HexaObserver extends AbstractObserver {

    @Override
    public void update(int state) {
        System.out.println("Hex String: " + Integer.toHexString(state).toUpperCase());
    }
}

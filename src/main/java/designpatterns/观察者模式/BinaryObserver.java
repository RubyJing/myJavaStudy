package designpatterns.观察者模式;


/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/3/2 14:34
 */
public class BinaryObserver extends AbstractObserver {
    @Override
    public void update(int state) {
        System.out.println("Binary String: " + Integer.toBinaryString(state));
    }
}

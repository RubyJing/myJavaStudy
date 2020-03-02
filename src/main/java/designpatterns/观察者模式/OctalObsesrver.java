package designpatterns.观察者模式;


/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/3/2 14:42
 */
public class OctalObsesrver extends AbstractObserver {

    @Override
    public void update(int state) {
        System.out.println("Octal String: " + Integer.toOctalString(state));
    }
}

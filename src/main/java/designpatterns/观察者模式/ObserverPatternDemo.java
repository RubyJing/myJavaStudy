package designpatterns.观察者模式;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/3/2 14:46
 */
public class ObserverPatternDemo {

    public static void main(String[] args) {
        Subject subject = new Subject();
        HexaObserver hexaObserver = new HexaObserver();
        OctalObsesrver octalObsesrver = new OctalObsesrver();
        BinaryObserver binaryObserver = new BinaryObserver();

        subject.addAttach(hexaObserver);
        subject.addAttach(octalObsesrver);
        subject.addAttach(binaryObserver);
        System.out.println("First state change : 15");
        subject.setState(15);
    }
}

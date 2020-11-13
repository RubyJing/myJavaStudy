package functionalModule.alert;

/**
 * 琐事通知
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/13 15:30
 */
public class TrivialNotification extends Notification {

    public TrivialNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        System.out.println("-----琐事通知----");
        msgSender.send(message);
    }
}

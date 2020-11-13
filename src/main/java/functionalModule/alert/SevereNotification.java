package functionalModule.alert;

/**
 * 严重通知
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/13 15:27
 */
public class SevereNotification extends Notification {

    public SevereNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        System.out.println("-----严重通知-----");
        msgSender.send(message);
    }
}

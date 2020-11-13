package functionalModule.alert;

/**
 * 一般通知
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/13 15:29
 */
public class NormalNotification extends Notification {

    public NormalNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        System.out.println("-----一般通知----");
        msgSender.send(message);
    }
}

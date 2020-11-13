package functionalModule.alert;

/**
 * 紧急通知
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/13 15:28
 */
public class UrgencyNotification extends Notification {

    public UrgencyNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        System.out.println("-----紧急通知----");
        msgSender.send(message);
    }
}

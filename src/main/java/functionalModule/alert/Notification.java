package functionalModule.alert;



/**
 * 告警通知抽象类
 *
 * 支持邮件、短信、微信、手机等多种通知渠道
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/10/30 8:45
 */
public abstract class Notification {

    protected MsgSender msgSender;

    public Notification(MsgSender msgSender) {
        this.msgSender = msgSender;
    }

    public abstract void notify(String message);
}

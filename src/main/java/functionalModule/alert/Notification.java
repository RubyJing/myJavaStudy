package functionalModule.alert;

import java.util.NoSuchElementException;

/**
 * 告警通知类
 * 支持邮件、短信、微信、手机等多种通知渠道
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/10/30 8:45
 */
public class Notification {

    public void notify(NotificationEmergencyLevel level, String message) {
        switch (level){
            case NORMAL:
                System.out.print("NORMAL:");
                break;
            case SEVERE:
                System.out.print("SEVERE:");
                break;
            case URGENCY:
                System.out.print("URGENCY:");
                break;
            case TRIVIAL:
                System.out.print("TRIVIAL:");
                break;
            default:
                throw new NoSuchElementException();
        }
        System.out.println(message);
    }
}

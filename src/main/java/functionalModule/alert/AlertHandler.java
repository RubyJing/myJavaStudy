package functionalModule.alert;

/**
 * 警报处理程序Handler抽象类
 * @author RubyJing
 * @version 1.0
 * @date 2020/10/30 10:34
 */
public abstract class AlertHandler {
    protected AlertRule rule;
    protected Notification notification;

    public AlertHandler(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    public abstract void check(ApiStatInfo  apiStatInfo);
}

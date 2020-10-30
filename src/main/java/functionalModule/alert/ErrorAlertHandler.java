package functionalModule.alert;

/**
 * 错误警告处理
 * @author RubyJing
 * @version 1.0
 * @date 2020/10/30 10:41
 */
public class ErrorAlertHandler extends AlertHandler{


    public ErrorAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        if (apiStatInfo.getErrorCount() > rule.getMarchedRule(apiStatInfo.getApi()).getMaxErrorCount()) {
            notification.notify(NotificationEmergencyLevel.SEVERE,"...");
        }
    }
}

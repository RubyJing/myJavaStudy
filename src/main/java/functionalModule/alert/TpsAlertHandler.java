package functionalModule.alert;

/**
 * tps警告处理
 * @author RubyJing
 * @version 1.0
 * @date 2020/10/30 10:39
 */
public class TpsAlertHandler extends AlertHandler {

    public TpsAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        long tps = apiStatInfo.getRequestCount() / apiStatInfo.getDurationOfSeconds();
        if (tps > rule.getMarchedRule(apiStatInfo.getApi()).getMaxTps()){
            notification.notify("...");
        }
    }
}

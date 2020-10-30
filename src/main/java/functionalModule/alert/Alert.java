package functionalModule.alert;

import java.util.ArrayList;
import java.util.List;

/**
 * 告警类
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/10/30 8:42
 */
public class Alert {

    //  =================================== 优化前 ======================================
//    private AlertRule rule;
//    private Notification notification;
//
//    public Alert(AlertRule alertRule, Notification notification) {
//        this.rule = alertRule;
//        this.notification = notification;
//    }
//    /**
//     * 告警
//     * 当TPS超过某个预先设置的最大值时，以及当接口请求出错数大于某个最大允许值时，就会触发告警，
//     * 通知接口相关负责人或者团队
//     * @param api 请求接口
//     * @param requestCount 请求数量
//     * @param errorCount 错误数量
//     * @param durationOfSeconds 持续时间
//     */
//    public void check(String api,long requestCount,long errorCount,long durationOfSeconds){
//        long tps = requestCount / durationOfSeconds;
//        if (tps > rule.getMarchedRule(api).getMaxTps()){
//            notification.notify(NotificationEmergencyLevel.URGENCY,"...");
//        }
//        if (errorCount > rule.getMarchedRule(api).getMaxErrorCount()){
//            notification.notify(NotificationEmergencyLevel.SEVERE,"...");
//        }
//    }

    //  =================================== 优化后 ======================================

    //将判断条件使用Handler

    private List<AlertHandler> alertHandlers = new ArrayList<>();

    public void addAlertHandler(AlertHandler alertHandler) {
        this.alertHandlers.add(alertHandler);
    }

    public void check(ApiStatInfo apiStatInfo) {
        for (AlertHandler handler : alertHandlers) {
            handler.check(apiStatInfo);
        }
    }
}

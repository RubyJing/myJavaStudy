package functionalModule.alert;


/**
 * 使用警告预警
 * @author RubyJing
 * @version 1.0
 * @date 2020/10/30 10:19
 */
public class AlertDemo {
    public static void main(String[] args) {
        //优化前
//        Alert alert = new Alert(new AlertRule(),new Notification());
//        alert.check("api1",120,50,1);
        //优化后
        ApiStatInfo apiStatInfo = new ApiStatInfo();
        apiStatInfo.setApi("api1");
        apiStatInfo.setRequestCount(120);
        apiStatInfo.setErrorCount(50);
        apiStatInfo.setDurationOfSeconds(1);
        ApplicationContext.getInstance().getAlert().check(apiStatInfo);
    }
}

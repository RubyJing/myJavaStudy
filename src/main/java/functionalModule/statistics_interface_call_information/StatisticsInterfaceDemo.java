package functionalModule.statistics_interface_call_information;

import functionalModule.statistics_interface_call_information.Prototype.*;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/3 17:17
 */
public class StatisticsInterfaceDemo {

    public static void main(String[] args) {
        //-----Prototype-----
        //普通代理实现
//        IUserController userController = new UserControllerProxy(new UserController());
        //动态代理实现
        MetricsProxy metricsProxy = new MetricsProxy(new Metrics());
        IUserController userController = (IUserController)metricsProxy.createProxy(new UserController());
        userController.login("421651","dfs");
        userController.login("421651","dfs");
        userController.login("421651","dfs");
        userController.login("421651","dfs");
        userController.register(new UserVo("测试","3131"));
        userController.register(new UserVo("测试","3131"));
        userController.register(new UserVo("测试","3131"));
        userController.register(new UserVo("测试","3131"));



        //完整版本
//        MetricsStorage storage = new RedisMetricsStorage();
//        ConsoleReporter consoleReporter = new ConsoleReporter(storage);
//        consoleReporter.startRepeatedReport(60,60);
//
//        MetricsCollector collector = new MetricsCollector(storage);
//        collector.recordRequest(new RequestInfo("register",123,10234));
//        collector.recordRequest(new RequestInfo("register",202,7142));
//        collector.recordRequest(new RequestInfo("register",36,10234));
//        collector.recordRequest(new RequestInfo("register",68,10234));
//        collector.recordRequest(new RequestInfo("login",123,10234));
//        collector.recordRequest(new RequestInfo("login",275,10234));
//        collector.recordRequest(new RequestInfo("login",130,10234));

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

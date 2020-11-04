package functionalModule.statistics_interface_call_information.Prototype;

import java.util.concurrent.TimeUnit;

/**
 * 应用场景：统计下面两个接口(注册和登录）的响应时间和访问次数
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/3 14:02
 */
public class UserController {

    private Metrics metrics = new Metrics();

    public UserController() {
        metrics.startRepeatedReport(30, TimeUnit.SECONDS);
    }

    public void register(UserVo userVo) {
        long startTimestamp = System.currentTimeMillis();
        metrics.recordTimestamp("register", startTimestamp);
        //..
        System.out.println("注册用户信息：" + userVo.toString());
        long respTime = System.currentTimeMillis() - startTimestamp;
        metrics.recordResponseTime("register", respTime);
    }

    public void login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        metrics.recordTimestamp("login", startTimestamp);
        //..
        System.out.println("登录账号:" + telephone + "，密码：" + password);
        long respTime = System.currentTimeMillis() - startTimestamp;
        metrics.recordResponseTime("login", respTime);
    }

}

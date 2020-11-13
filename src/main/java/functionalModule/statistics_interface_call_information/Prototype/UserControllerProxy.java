package functionalModule.statistics_interface_call_information.Prototype;

import java.util.concurrent.TimeUnit;

/**
 * 用户代理类
 * 应用场景：统计下面两个接口(注册和登录）的响应时间和访问次数
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/12 16:54
 */
public class UserControllerProxy implements IUserController {

    private UserController userController;
    private Metrics metrics;

    public UserControllerProxy(UserController userController) {
        this.userController = userController;
        metrics = new Metrics();
        metrics.startRepeatedReport(30, TimeUnit.SECONDS);
    }

    @Override
    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        metrics.recordTimestamp("login", startTimestamp);
        userController.login(telephone,password);
        long respTime = System.currentTimeMillis() - startTimestamp;
        metrics.recordResponseTime("login", respTime);
        return new UserVo("xx",telephone);
    }

    @Override
    public void register(UserVo userVo) {
        long startTimestamp = System.currentTimeMillis();
        metrics.recordTimestamp("register", startTimestamp);
        userController.register(userVo);
        long respTime = System.currentTimeMillis() - startTimestamp;
        metrics.recordResponseTime("register", respTime);
    }
}

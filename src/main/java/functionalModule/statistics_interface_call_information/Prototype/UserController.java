package functionalModule.statistics_interface_call_information.Prototype;


/**
 *
 * 用户
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/3 14:02
 */
public class UserController implements IUserController{

    @Override
    public void register(UserVo userVo) {
        //..
        System.out.println("注册用户信息：" + userVo.toString());

    }

    @Override
    public UserVo login(String telephone, String password) {
        System.out.println("登录账号:" + telephone + "，密码：" + password);
        return new UserVo("xx",telephone);
    }

}

package functionalModule.statistics_interface_call_information.Prototype;



/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/12 16:50
 */
public interface IUserController {
    UserVo login(String telephone, String password);

    void register(UserVo userVo);
}

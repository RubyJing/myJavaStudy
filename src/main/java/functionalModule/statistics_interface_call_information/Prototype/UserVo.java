package functionalModule.statistics_interface_call_information.Prototype;

/**
 * 用户信息Vo
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/3 14:02
 */
public class UserVo {
    private String name;
    private String telephone;

    public UserVo(String name, String telephone) {
        this.name = name;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "姓名='" + name + '\'' +
                ", 手机号='" + telephone + '\'' +
                '}';
    }
}

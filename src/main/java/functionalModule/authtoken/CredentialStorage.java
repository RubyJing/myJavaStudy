package functionalModule.authtoken;

/**
 * 持久层
 * @author RubyJing
 * @version 1.0
 * @date 2020/10/19 15:24
 */
public class CredentialStorage {
    String getPasswordByAppId(String appId){
        if ("zhou".equals(appId)){
            return "jing";
        }
        if ("Ruby".equals(appId)) {
            return "Jing";
        }
        return "123456";
    }
}

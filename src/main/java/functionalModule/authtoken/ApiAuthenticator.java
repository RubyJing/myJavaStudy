package functionalModule.authtoken;

/**
 * 外部调用api接口
 * @author RubyJing
 * @version 1.0
 * @date 2020/10/19 15:26
 */
public interface ApiAuthenticator {
    void auth(String url);

    void auth(ApiRequest apiRequest);
}

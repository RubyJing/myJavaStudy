package functionalModule.authtoken;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/10/19 16:11
 */
public class TokenTest {

    public static void main(String[] args) {
        String url = "https://baidu.com";
        String appId = "zhou";
        long currTime = System.currentTimeMillis();
        ApiAuthenticator apiAuthenticator = new DefaultApiAuthenticatorImpl(new CredentialStorage());
        String clientToken = AuthToken.getToken("https://baidu.com", appId, "jing", currTime);
        apiAuthenticator.auth(url + "?appId=" + appId + "&token=" + clientToken + "&timestamp=" + currTime);
    }
}

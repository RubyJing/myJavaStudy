package tips.authtoken;

/**
 * 触发执行鉴权逻辑的默认执行类
 * @author RubyJing
 * @version 1.0
 * @date 2020/10/19 15:28
 */
public class DefaultApiAuthenticatorImpl implements ApiAuthenticator {

    private CredentialStorage credentialStorage;

    public DefaultApiAuthenticatorImpl(CredentialStorage credentialStorage) {
        this.credentialStorage = credentialStorage;
    }

    public DefaultApiAuthenticatorImpl() {
    }

    @Override
    public void auth(String url) {
        ApiRequest apiRequest = ApiRequest.createFromFullUrl(url);
        auth(apiRequest);
    }

    @Override
    public void auth(ApiRequest apiRequest) {
        String appId = apiRequest.getAppId();
        String token = apiRequest.getToken();
        long timestamp = apiRequest.getTimestamp();
        String originalUrl = apiRequest.getBaseUrl();

        //是否超时
        AuthToken clientAuthToken = new AuthToken(token,timestamp);
        if (clientAuthToken.isExpired()){
            throw new RuntimeException("Token is expired");
        }

        //生成结果是否一致
        String password = credentialStorage.getPasswordByAppId(appId);
        AuthToken serverAuthToken = AuthToken.create(originalUrl,appId,password,timestamp);
        if (! serverAuthToken.match(clientAuthToken)){
            throw new RuntimeException("Token verfication failed.");
        }

        System.out.println("授权成功");
    }
}

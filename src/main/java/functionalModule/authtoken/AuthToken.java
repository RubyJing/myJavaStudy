package functionalModule.authtoken;


/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/10/15 14:50
 */
public class AuthToken {
    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 1 * 60 * 1000;
    private String token;
    private long createTime;
    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }

    public AuthToken(String token, long createTime, long expiredTimeInterval) {
        this.token = token;
        this.createTime = createTime;
        this.expiredTimeInterval = expiredTimeInterval;
    }


    public static AuthToken create(String baseUrl, String appId, String password, long createTime) {
        //生成token
        return new AuthToken(getToken(baseUrl, appId, password, createTime), createTime);
    }

    public static String getToken(String baseUrl, String appId, String password, long createTime) {
        return baseUrl + "url" + appId + "10" + password + "time:" + createTime;
    }


    /**
     * 是否失效
     *
     * @return boolean
     */
    public boolean isExpired() {
        long currTime = System.currentTimeMillis();
        return expiredTimeInterval + createTime < currTime;
    }

    /**
     * 是否一致
     *
     * @param authToken 传入的token类
     * @return boolean
     */
    public boolean match(AuthToken authToken) {
        return authToken.token.equals(this.token);
    }

}

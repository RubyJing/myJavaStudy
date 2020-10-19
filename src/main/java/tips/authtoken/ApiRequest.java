package tips.authtoken;

/**
 * api请求
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/10/19 15:08
 */
public class ApiRequest {

    private String baseUrl;
    private String token;
    private String appId;
    private long timestamp;

    public ApiRequest(String baseUrl, String appId, String token, long timestamp) {
        this.baseUrl = baseUrl;
        this.appId = appId;
        this.token = token;
        this.timestamp = timestamp;
    }

    public static ApiRequest createFromFullUrl(String url) {
        String baseUrl, token = null, appId = null, timestamp = null;
        //解析url
        String[] urls = url.split("\\?");
        baseUrl = urls[0];
        String[] allParams = urls[1].split("&");
        for (String param : allParams) {
            String[] params = param.split("=");
            if ("token".equals(params[0])) {
                token = params[1];
            }
            if ("appId".equals(params[0])) {
                appId = params[1];
            }
            if ("timestamp".equals(params[0])) {
                timestamp = params[1];
            }
        }
        return new ApiRequest(baseUrl, appId, token,
                timestamp != null ? Long.parseLong(timestamp) : 0);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getToken() {
        return token;
    }

    public String getAppId() {
        return appId;
    }

    public long getTimestamp() {
        return timestamp;
    }


}

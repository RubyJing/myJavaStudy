package functionalModule.statistics_interface_call_information;

import java.util.List;
import java.util.Map;

/**
 * Redis存储
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/3 16:33
 */
public class RedisMetricsStorage implements MetricsStorage {
    @Override
    public void saveRequestInfo(RequestInfo requestInfo) {
        //..
    }

    @Override
    public List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis) {
        return null;
    }

    @Override
    public Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis) {
        return null;
    }
}

package functionalModule.statistics_interface_call_information;

import java.util.List;
import java.util.Map;

/**
 * 负责原始数据存储
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/3 15:23
 */
public interface MetricsStorage {

    /**
     * 保存请求数据
     *
     * @param requestInfo 请求信息
     */
    void saveRequestInfo(RequestInfo requestInfo);

    /**
     * 获取某接口时间段的请求信息
     * @param apiName 接口名称
     * @param startTimeInMillis 开始时间
     * @param endTimeInMillis 结束时间
     * @return List<RequestInfo>
     */
    List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis,long endTimeInMillis);

    /**
     * 获取时间段的请求信息
     * @param startTimeInMillis 开始时间
     * @param endTimeInMillis 结束时间
     * @return Map<String,List<RequestInfo>>
     */
    Map<String,List<RequestInfo>> getRequestInfos(long startTimeInMillis,long endTimeInMillis);

}

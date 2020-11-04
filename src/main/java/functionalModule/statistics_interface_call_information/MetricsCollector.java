package functionalModule.statistics_interface_call_information;


/**
 * 提供API，来采集接口请求的原始数据
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/3 15:23
 */
public class MetricsCollector {

    //基于接口而非实现编程

    private MetricsStorage metricsStorage;

    //依赖注入

    public MetricsCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || requestInfo.getApiName() != null){
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }
}

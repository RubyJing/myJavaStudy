package functionalModule.statistics_interface_call_information.Prototype;

import com.google.gson.Gson;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 采集接口请求信息
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/3 14:07
 */
public class Metrics {
    // Map的key是接口名称，value对应请求的响应时间或请求的时间戳

    private Map<String, List<Double>> responseTimes = new HashMap<>();
    private Map<String, List<Double>> timestamps = new HashMap<>();

    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public void recordResponseTime(String apiName, double responseTime) {
        responseTimes.putIfAbsent(apiName, new ArrayList<>());
        responseTimes.get(apiName).add(responseTime);
    }

    public void recordTimestamp(String apiName, double timestamp) {
        timestamps.putIfAbsent(apiName, new ArrayList<>());
        timestamps.get(apiName).add(timestamp);
    }

    public void startRepeatedReport(long period, TimeUnit unit) {
        executor.scheduleAtFixedRate(() -> {
            Gson gson = new Gson();
            Map<String, Map<String, Double>> stats = new HashMap<>();
            for (Map.Entry<String, List<Double>> entry : responseTimes.entrySet()) {
                String apiName = entry.getKey();
                List<Double> apiRespTimes = entry.getValue();
                stats.get(apiName).put("max", max(apiRespTimes));
                stats.get(apiName).put("avg", avg(apiRespTimes));
            }

            for (Map.Entry<String, List<Double>> entry : timestamps.entrySet()) {
                String apiName = entry.getKey();
                List<Double> apiTimestamps = entry.getValue();
                stats.putIfAbsent(apiName, new HashMap<>());
                stats.get(apiName).put("count", (double) apiTimestamps.size());
            }

            System.out.println(gson.toJson(stats));

        }, 0, period, unit);
    }

    private double max(List<Double> doubles) {
        return Optional.of(doubles.stream().max(Comparator.naturalOrder())).get().orElse(0.0d);
    }

    private double avg(List<Double> doubles) {
        double sum = 0.0d;
        if (doubles == null || doubles.size() == 0) {
            return sum;
        }

        for (Double aDouble : doubles) {
            sum += aDouble;
        }
        return sum / doubles.size();
    }
}

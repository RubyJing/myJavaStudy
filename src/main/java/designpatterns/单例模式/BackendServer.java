package designpatterns.单例模式;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 多例模式：银行服务
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/10 11:02
 */
public class BackendServer {
    private long serverNo;
    private String serverAddress;

    private static final int SERVER_COUNT = 3;
    private static final Map<Long, BackendServer> SERVER_INSTANCES = new HashMap<>();

    static {
        SERVER_INSTANCES.put(1L, new BackendServer(1L, "192.134.22.138:8080"));
        SERVER_INSTANCES.put(2L, new BackendServer(2L, "192.134.22.139:8080"));
        SERVER_INSTANCES.put(3L, new BackendServer(3L, "192.134.22.140:8080"));
    }

    public BackendServer(long serverNo, String serverAddress) {
        this.serverNo = serverNo;
        this.serverAddress = serverAddress;
    }

    public BackendServer getInstance(long serverNo) {
        return SERVER_INSTANCES.get(serverNo);
    }

    public BackendServer getRandomInstance() {
        Random r = new Random();
        int no = r.nextInt(SERVER_COUNT) + 1;
        return SERVER_INSTANCES.get(no);
    }
}

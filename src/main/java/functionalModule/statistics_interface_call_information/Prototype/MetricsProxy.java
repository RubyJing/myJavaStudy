package functionalModule.statistics_interface_call_information.Prototype;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理-采集接口请求信息
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/13 9:19
 */
public class MetricsProxy {
    private Metrics metrics;

    public MetricsProxy(Metrics metrics) {
        this.metrics = new Metrics();
    }

    public Object createProxy(Object proxiedObject) {
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        DynamicProxyHandler handler = new DynamicProxyHandler(proxiedObject);
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(),interfaces,handler);
    }


    /**
     * 动态代理处理程序
     */
    private class DynamicProxyHandler implements InvocationHandler {
        private Object proxiedObject;

        public DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long startTimestamp = System.currentTimeMillis();
            String apiName = proxiedObject.getClass().getName() + ":" + method.getName();
            metrics.recordTimestamp(apiName, startTimestamp);

            Object result = method.invoke(proxiedObject, args);

            long respTime = System.currentTimeMillis() - startTimestamp;
            metrics.recordResponseTime(apiName, respTime);
            return result;
        }
    }
}

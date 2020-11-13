package designpatterns.代理模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.LocalDateTime;

/**
 * 动态代理类
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/13 11:29
 */
public class DynamicProxy {

    public static Object create(Object beProxied) {
        return Proxy.newProxyInstance(beProxied.getClass().getClassLoader(),
                beProxied.getClass().getInterfaces(), new PursuitDynamicProxyHandle(beProxied));
    }

    private static class PursuitDynamicProxyHandle implements InvocationHandler {

        private Object beProxied;

        public PursuitDynamicProxyHandle(Object beProxied) {
            this.beProxied = beProxied;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //在所有方法执行前加入时间打印
            System.out.print(LocalDateTime.now() + ":");
            return method.invoke(beProxied, args);
        }
    }
}

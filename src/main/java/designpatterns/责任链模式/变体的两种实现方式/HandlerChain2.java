package designpatterns.责任链模式.变体的两种实现方式;

import java.util.ArrayList;
import java.util.List;

/**
 * 方式二：使用数组结构
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/23 16:26
 */
public class HandlerChain2 {
    private List<IHandler> handlers = new ArrayList<>();

    public void addHandler(IHandler handler) {
        this.handlers.add(handler);
    }

    public void handle() {
        for (IHandler handler : handlers) {
            handler.doHandle();
        }
    }
}

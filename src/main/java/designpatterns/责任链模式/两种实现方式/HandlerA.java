package designpatterns.责任链模式.两种实现方式;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/23 16:01
 */
public class HandlerA extends Handler implements IHandler {
    @Override
    public boolean doHandle() {
        boolean handled = false;
        //...
        System.out.println("HandlerA");
        return handled;
    }
}

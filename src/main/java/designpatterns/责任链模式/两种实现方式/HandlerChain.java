package designpatterns.责任链模式.两种实现方式;

/**
 * 处理程序链方式一:使用链表结构
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/23 16:05
 */
public class HandlerChain {
    private Handler head = null;
    private Handler tail = null;

    public void addHandler(Handler handler){
        handler.setSuccessor(null);

        if (head == null){
            head = handler;
            tail = handler;
            return;
        }

        tail.setSuccessor(handler);
        tail = handler;

    }

    public void handle(){
        if (head != null){
            head.handle();
        }
    }
}

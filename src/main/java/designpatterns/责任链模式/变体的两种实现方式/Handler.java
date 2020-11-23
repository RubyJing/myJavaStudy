package designpatterns.责任链模式.变体的两种实现方式;

/**
 * 方式一：使用抽象类继承
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/23 16:00
 */
public abstract class Handler {
    protected Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public final void handle() {
        doHandle();
        //还有后续链，继续处理
        if (successor != null) {
            successor.handle();
        }
    }

    public abstract boolean doHandle();

}

package designpatterns.命令模式.example;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2021/1/29 17:12
 */
public class ConcreteCommand implements Command {

    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.action();
    }
}

package designpatterns.命令模式.example;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2021/1/29 17:14
 */
public class Client {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        invoker.action();
    }

}

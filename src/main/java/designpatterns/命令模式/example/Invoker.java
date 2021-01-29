package designpatterns.命令模式.example;

/**
 * 客户端调用者
 * @author RubyJing
 * @version 1.0
 * @date 2021/1/29 17:13
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void action(){
        this.command.execute();
    }

}

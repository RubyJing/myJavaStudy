package designpatterns.命令模式.example;

/**
 * 接收者
 * @author RubyJing
 * @version 1.0
 * @date 2021/1/29 17:10
 */
public class Receiver {

    public void action(){
        //=====================
        // 真正的业务逻辑
        //=====================

        System.out.println("执行具体Receiver的action()业务");
    }
}

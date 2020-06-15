package designpatterns.命令模式;

/**
 * 请求类
 * @author RubyJing
 * @version 1.0
 * @date 2020/6/15 15:30
 */
public class Stock {
    private String name = "ABC";
    private int quantity = 10;

    public void buy(){
        System.out.println("Stock [ Name "+name
                +",Quantity: "+quantity
                +" ] bought");
    }

    public void sell(){
        System.out.println("Stock [ Name "+name
                +",Quantity "+quantity+" ] sold");
    }
}

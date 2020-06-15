package designpatterns.命令模式;



import java.util.ArrayList;
import java.util.List;

/**
 * 命令调用类
 * @author RubyJing
 * @version 1.0
 * @date 2020/6/15 15:35
 */
public class Broker {
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order){
        orderList.add(order);
    }

    public void placeOrders(){
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }

}

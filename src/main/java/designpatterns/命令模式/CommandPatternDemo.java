package designpatterns.命令模式;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/6/15 15:37
 */
public class CommandPatternDemo{
    public static void main(String[] args) {
        Stock stock = new Stock();

        BuyStock buyStock = new BuyStock(stock);
        SellStock sellStock = new SellStock(stock);

        Broker broker = new Broker();
        broker.takeOrder(buyStock);
        broker.takeOrder(sellStock);

        broker.placeOrders();
    }
}

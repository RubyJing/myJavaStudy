package designpatterns.命令模式;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/6/15 15:34
 */
public class SellStock implements Order {
    private Stock stock;

    public SellStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.sell();
    }
}

package designpatterns.命令模式;

/**
 * 实现类
 * @author RubyJing
 * @version 1.0
 * @date 2020/6/15 15:33
 */
public class BuyStock implements Order {
    private Stock stock;

    public BuyStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}

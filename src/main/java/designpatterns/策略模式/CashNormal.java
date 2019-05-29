package designpatterns.策略模式;

/**
 * 正常收费
 */
public class CashNormal implements CashSuper {
    @Override
    public double acceptCash(double money) {
        return money;
    }
}

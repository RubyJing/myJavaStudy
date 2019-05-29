package designpatterns.策略模式;

/**
 * 现金收费抽象接口
 */
public interface CashSuper {
    /**
     * 收银
     * @param money
     * @return
     */
    double acceptCash(double money);
}

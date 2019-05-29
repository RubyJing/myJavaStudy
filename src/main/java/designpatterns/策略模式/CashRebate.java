package designpatterns.策略模式;

/**
 * 打折收费
 */
public class CashRebate implements CashSuper {
    /** 折扣倍数 **/
    private double moneyRebate = 1d;

    public CashRebate(String moneyRebate){
        this.moneyRebate = Double.parseDouble(moneyRebate);
    }

    @Override
    public double acceptCash(double money) {
        return money * moneyRebate;
    }
}

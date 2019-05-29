package designpatterns.策略模式;

/**
 * 返利收费子类
 */
public class CashReturn implements CashSuper {
    /** 符合要求的金额 **/
    private double moneyCondition = 0.0d;
    /** 返利的金额 **/
    private double moneyReturn = 0.0d;

    public CashReturn(String moneyCondition, String moneyReturn) {
        this.moneyCondition = Double.parseDouble(moneyCondition);
        this.moneyReturn = Double.parseDouble(moneyReturn);
    }

    @Override
    public double acceptCash(double money) {
        double result = money;
        if (money >= moneyCondition){
            result = money - Math.floor(money/moneyCondition)*moneyReturn;
        }
        return result;
    }
}

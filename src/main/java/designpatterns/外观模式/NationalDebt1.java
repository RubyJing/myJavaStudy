package designpatterns.外观模式;

//国债
public class NationalDebt1 {
    /**
     * 卖股票
     */
    public void Sell(){
        System.out.println("国债卖出");
    }

    /**
     * 买股票
     */
    public void Buy(){
        System.out.println("国债买入");
    }
}

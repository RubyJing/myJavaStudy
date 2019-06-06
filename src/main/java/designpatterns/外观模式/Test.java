package designpatterns.外观模式;

public class Test {
    public static void main(String[] args) {
//        Stock1 qu1 = new Stock1();
//        Stock2 qu2 = new Stock2();
//        Stock3 qu3 = new Stock3();
//        NationalDebt1 nd1 = new NationalDebt1();
//        Realty1 rt1 = new Realty1();
//
//        qu1.Buy();
//        qu2.Buy();
//        qu3.Buy();
//        nd1.Buy();
//        rt1.Buy();
//
//        qu1.Sell();
//        qu2.Sell();
//        qu3.Sell();
//        nd1.Sell();
//        rt1.Sell();

        //外观模式
        Fund jijin = new Fund();
        jijin.BuyFund();
        jijin.SellFund();
    }
}

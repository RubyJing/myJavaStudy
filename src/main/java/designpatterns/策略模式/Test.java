package designpatterns.策略模式;

public class Test {
    public static void main(String[] args) {
        /**
         * 工厂模式
         */
//        CashSuper cashSuper = CashFactory.createCashAccept(CashType.TYPE_NORMALE);
//        System.out.println("退回金额："+cashSuper.acceptCash(400));
//        cashSuper = CashFactory.createCashAccept(CashType.TYPE_300_RETURN_100);
//        System.out.println("(满300-100)退回金额："+cashSuper.acceptCash(400));
//        cashSuper = CashFactory.createCashAccept(CashType.TYPE_REBATE_8);
//        System.out.println("(打8折)退回金额："+cashSuper.acceptCash(400));
        /**
         * 策略模式
         */
//            double total = 0.0d;
//            CashContext cashContext = null;
//            String type=null;
//            type = CashType.TYPE_REBATE_8;
//            switch (type){
//                case CashType.TYPE_NORMALE:
//                    cashContext = new CashContext(new CashNormal());
//                    break;
//                case CashType.TYPE_300_RETURN_100:
//                    cashContext = new CashContext(new CashReturn("300","100"));
//                    break;
//                case CashType.TYPE_REBATE_8:
//                    cashContext = new CashContext(new CashRebate("0.8"));
//                    break;
//            }
//            double totalPrices = 0d;
//            totalPrices = cashContext.GetResult(400);
//            System.out.println("价格："+totalPrices);

        /**
         * 策略模式和工厂模式结合
         */
        CashContext cashContext = new CashContext(CashType.TYPE_300_RETURN_100);
        cashContext.GetResult(400);
        System.out.println("价格："+cashContext.GetResult(400));
    }
}

package designpatterns.策略模式;

public class CashFactory {
    /**
     * 现金收取工厂
     * @param type
     * @return
     */
    public static CashSuper createCashAccept(String type){
        CashSuper cs = null;
        switch (type){
            case CashType.TYPE_NORMALE:
                cs = new CashNormal();
                break;
            case CashType.TYPE_300_RETURN_100:
                CashReturn cr = new CashReturn("300","100");
                cs = cr;
                break;
            case CashType.TYPE_REBATE_8:
                CashRebate cr2 = new CashRebate("0.8");
                cs = cr2;
                break;
        }
        return cs;
    }
}


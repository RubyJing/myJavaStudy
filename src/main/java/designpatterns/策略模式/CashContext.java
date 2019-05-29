package designpatterns.策略模式;

public class CashContext {

    private CashSuper cs;

    public CashContext(CashSuper cs) {
        this.cs = cs;
    }

    public CashContext(String type){
        switch (type){
            case CashType.TYPE_NORMALE:
                CashNormal cs = new CashNormal();
                this.cs = cs;
                break;
            case CashType.TYPE_300_RETURN_100:
                CashReturn cs2 = new CashReturn("300","100");
                this.cs = cs2;
                break;
            case CashType.TYPE_REBATE_8:
                CashRebate cs3 = new CashRebate("0.8");
                this.cs = cs3;
                break;
        }
    }

    public double GetResult(double money){
        return cs.acceptCash(money);
    }
}

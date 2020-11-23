package designpatterns.策略模式;

import java.util.HashMap;
import java.util.Map;

public class CashStrategyFactory {

    private static final Map<String, CashSuper> cashStrategies = new HashMap<>();

    static {
        cashStrategies.put(CashType.TYPE_NORMALE, new CashNormal());
        cashStrategies.put(CashType.TYPE_300_RETURN_100, new CashReturn("300", "100"));
        cashStrategies.put(CashType.TYPE_REBATE_8, new CashRebate("0.8"));
    }

    public static CashSuper getStrategy(String cashType){
        if (cashType == null || cashType.isEmpty()){
            throw new IllegalArgumentException("cashType should not be empty.");
        }
        return cashStrategies.get(cashType);
    }
}

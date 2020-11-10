package designpatterns.工厂模式.工厂方法;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂的工厂
 * 因为工厂类只包含方法，不包含成员变量，完全可以复用
 * 不需要每次都创建新的工厂类对象，所以，简单工厂模式的第二种实现思路更加合适。
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/10 14:57
 */
public class RuleConfigParserFactoryMap {
    private static final Map<String,IRuleConfigParserFactory> cachedFactories =
            new HashMap<>();

    static {
        cachedFactories.put("json",new JsonRuleConfigParserFactory());
        cachedFactories.put("xml",new XmlRuleConfigParserFactory());
        cachedFactories.put("yaml",new YamlRuleConfigParserFactory());
        cachedFactories.put("properties",new PropertiesRuleConfigParserFactory());
    }

    public static IRuleConfigParserFactory getParserFactory(String type){
        if (type == null || type.isEmpty()){
            return null;
        }
        IRuleConfigParserFactory parserFactory = cachedFactories.get(type);
        return parserFactory;
    }
}

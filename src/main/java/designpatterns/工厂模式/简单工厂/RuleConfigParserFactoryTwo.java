package designpatterns.工厂模式.简单工厂;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单工厂模式第一种 实现方法
 * 类似单例模式和简单工厂模式的结合
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/10 14:29
 */
public class RuleConfigParserFactoryTwo {
    private static final Map<String,IRuleConfigParser> cachedParsers = new HashMap<>();

    static {
        cachedParsers.put("json",new JsonRuleConfigParser());
        cachedParsers.put("xml",new XmlRuleConfigParser());
        cachedParsers.put("yaml",new YamlRuleConfigParser());
        cachedParsers.put("properties",new PropertiesRuleConfigParser());
    }

    public static IRuleConfigParser createParser(String configFormat){
        if (configFormat == null || configFormat.isEmpty()){
            return null;
        }
        IRuleConfigParser parser = cachedParsers.get(configFormat.toLowerCase());
        return parser;
    }
}

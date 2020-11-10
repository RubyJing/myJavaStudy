package designpatterns.工厂模式.简单工厂;

/**
 * 简单工厂模式第一种 实现方法
 * 规则配置解析器生成工厂
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/10 14:19
 */
public class RuleConfigParserFactory {

    public static IRuleConfigParser create(String configFormat) {
        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(configFormat)) {
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(configFormat)) {
            parser = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(configFormat)) {
            parser = new YamlRuleConfigParser();
        } else if ("properties".equalsIgnoreCase(configFormat)) {
            parser = new PropertiesRuleConfigParser();
        }
        return parser;
    }


}

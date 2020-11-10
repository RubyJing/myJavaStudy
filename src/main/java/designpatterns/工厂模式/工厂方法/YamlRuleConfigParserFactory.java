package designpatterns.工厂模式.工厂方法;

import designpatterns.工厂模式.IRuleConfigParser;
import designpatterns.工厂模式.YamlRuleConfigParser;

/**
 * Yaml 工厂
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/10 14:55
 */
public class YamlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new YamlRuleConfigParser();
    }
}

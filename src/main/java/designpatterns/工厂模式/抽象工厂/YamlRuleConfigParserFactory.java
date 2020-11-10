package designpatterns.工厂模式.抽象工厂;

import designpatterns.工厂模式.IRuleConfigParser;
import designpatterns.工厂模式.ISystemConfigParser;
import designpatterns.工厂模式.YamlRuleConfigParser;
import designpatterns.工厂模式.YamlSystemConfigParser;

/**
 * Yaml 工厂
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/10 15:35
 */
public class YamlRuleConfigParserFactory implements IConfigParserFactory {
    @Override
    public IRuleConfigParser createRuleParser() {
        return new YamlRuleConfigParser();
    }

    @Override
    public ISystemConfigParser createSystemParser() {
        return new YamlSystemConfigParser();
    }
}

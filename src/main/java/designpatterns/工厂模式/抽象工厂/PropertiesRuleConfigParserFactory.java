package designpatterns.工厂模式.抽象工厂;

import designpatterns.工厂模式.IRuleConfigParser;
import designpatterns.工厂模式.ISystemConfigParser;
import designpatterns.工厂模式.PropertiesRuleConfigParser;
import designpatterns.工厂模式.PropertiesSystemConfigParser;

/**
 * Properties 工厂
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/10 15:34
 */
public class PropertiesRuleConfigParserFactory implements IConfigParserFactory {
    @Override
    public IRuleConfigParser createRuleParser() {
        return new PropertiesRuleConfigParser();
    }

    @Override
    public ISystemConfigParser createSystemParser() {
        return new PropertiesSystemConfigParser();
    }
}

package designpatterns.工厂模式.抽象工厂;

import designpatterns.工厂模式.IRuleConfigParser;
import designpatterns.工厂模式.ISystemConfigParser;
import designpatterns.工厂模式.XmlRuleConfigParser;
import designpatterns.工厂模式.XmlSystemConfigParser;

/**
 * Xml工厂
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/10 15:34
 */
public class XmlRuleConfigParserFactory implements IConfigParserFactory {
    @Override
    public IRuleConfigParser createRuleParser() {
        return new XmlRuleConfigParser();
    }

    @Override
    public ISystemConfigParser createSystemParser() {
        return new XmlSystemConfigParser();
    }
}

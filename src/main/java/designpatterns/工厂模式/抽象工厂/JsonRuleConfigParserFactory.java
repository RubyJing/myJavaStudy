package designpatterns.工厂模式.抽象工厂;

import designpatterns.工厂模式.IRuleConfigParser;
import designpatterns.工厂模式.ISystemConfigParser;
import designpatterns.工厂模式.JsonRuleConfigParser;
import designpatterns.工厂模式.JsonSystemConfigParser;

/**
 * Json 工厂
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/10 15:33
 */
public class JsonRuleConfigParserFactory implements IConfigParserFactory {
    @Override
    public IRuleConfigParser createRuleParser() {
        return new JsonRuleConfigParser();
    }

    @Override
    public ISystemConfigParser createSystemParser() {
        return new JsonSystemConfigParser();
    }
}

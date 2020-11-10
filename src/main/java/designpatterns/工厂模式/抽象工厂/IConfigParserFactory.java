package designpatterns.工厂模式.抽象工厂;

import designpatterns.工厂模式.IRuleConfigParser;
import designpatterns.工厂模式.ISystemConfigParser;

/**
 * 配置解析器工厂
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/10 15:31
 */
public interface IConfigParserFactory {

    /**
     * 创建规则配置的解析器
     * @return IRuleConfigParser
     */
    IRuleConfigParser createRuleParser();

    /**
     * 创建系统配置的解析器
     * @return ISystemConfigParser
     */
    ISystemConfigParser createSystemParser();

}

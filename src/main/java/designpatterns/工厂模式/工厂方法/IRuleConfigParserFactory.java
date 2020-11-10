package designpatterns.工厂模式.工厂方法;

import designpatterns.工厂模式.IRuleConfigParser;

/**
 * 规则配置解析工厂
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/10 14:52
 */
public interface IRuleConfigParserFactory {

    /**
     * 创建解析实例
     * @return IRuleConfigParser
     */
    IRuleConfigParser createParser();
}

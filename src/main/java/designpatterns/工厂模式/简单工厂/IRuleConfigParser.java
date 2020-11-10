package designpatterns.工厂模式.简单工厂;

/**
 * 规则配置解析器
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/10 14:18
 */
public interface IRuleConfigParser {
    /**
     * 读取文本生成规则配置
     * @param configText 文本
     * @return RuleConfig
     */
    RuleConfig parse(String configText);
}

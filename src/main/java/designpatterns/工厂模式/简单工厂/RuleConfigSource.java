package designpatterns.工厂模式.简单工厂;

/**
 * 通过规则配置源
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/10 14:14
 */
public class RuleConfigSource {

    public RuleConfig load(String ruleConfigFilePath) {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = RuleConfigParserFactory.create(ruleConfigFileExtension);
        String configText = "";
        //从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        //...解析文件名获取扩展名，比如rule.json，返回json return "json"; }
        return "json";
    }
}

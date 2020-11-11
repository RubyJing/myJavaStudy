package functionalModule.simple_dependency_Injection_container;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Xml Bean配置解析器
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/11 10:18
 */
public class XmlBeanConfigParser implements BeanConfigParser {
    @Override
    public List<BeanDefinition> parse(InputStream in) {
        String context = null;
        // TODO 实现
        return parse(context);
    }

    @Override
    public List<BeanDefinition> parse(String configContext) {
        List<BeanDefinition> beanDefinitions = new ArrayList<>();
        // TODO :...
        return beanDefinitions;
    }
}

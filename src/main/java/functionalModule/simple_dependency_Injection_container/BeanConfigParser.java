package functionalModule.simple_dependency_Injection_container;

import java.io.InputStream;
import java.util.List;

/**
 * Bean 配置解析器
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/11 10:15
 */
public interface BeanConfigParser {

    /**
     * 将输入流解析成Bean定义类List
     * @param in 输入流
     * @return  List<BeanDefinition>
     */
    List<BeanDefinition> parse(InputStream in);

    /**
     * 将配置上下文解析成Bean定义类List
     * @param configContext 配置上下文
     * @return  List<BeanDefinition>
     */
    List<BeanDefinition> parse(String configContext);
}

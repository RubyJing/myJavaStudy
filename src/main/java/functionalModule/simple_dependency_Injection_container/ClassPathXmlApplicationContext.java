package functionalModule.simple_dependency_Injection_container;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 类路径Xml应用程序上下文
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/11 10:09
 */
public class ClassPathXmlApplicationContext implements ApplicationContext {

    private BeansFactory beansFactory;
    private BeanConfigParser beanConfigParser;

    public ClassPathXmlApplicationContext(String configLocation) {
        this.beansFactory = new BeansFactory();
        this.beanConfigParser = new XmlBeanConfigParser();
        try {
            loadBeanDefinitions(configLocation);
        } catch (BeanCreationFailureException e) {
            e.printStackTrace();
        }
    }

    private void loadBeanDefinitions(String configLocation) throws BeanCreationFailureException {
        InputStream in = null;
        try {
            in = this.getClass().getResourceAsStream("/" + configLocation);
            if (in == null) {
                throw new RuntimeException("Can not find config file: " + configLocation);
            }
            List<BeanDefinition> beanDefinitions = beanConfigParser.parse(in);
            beansFactory.addBeanDefinitions(beanDefinitions);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public Object getBean(String beanId) {
        Object instance = null;
        try {
            instance = beansFactory.getBean(beanId);
        } catch (NoSuchBeanDefinitionException | BeanCreationFailureException e) {
            e.printStackTrace();
        }
        return instance;
    }
}

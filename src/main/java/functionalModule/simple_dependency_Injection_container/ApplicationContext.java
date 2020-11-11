package functionalModule.simple_dependency_Injection_container;

/**
 * 应用环境接口
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/11 10:08
 */
public interface ApplicationContext {
    /**
     * 通过beanId获取对象
     * @param beanId beanId
     * @return 对象
     */
    Object getBean(String beanId);
}

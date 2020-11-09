package functionalModule.id_generator;

/**
 * id生成器接口（重构后）
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/6 10:33
 */
public interface IdGeneratorNew {

    /**
     * 生成id
     * @return id
     */
    String generate() throws IdGenerationFailureException;
}

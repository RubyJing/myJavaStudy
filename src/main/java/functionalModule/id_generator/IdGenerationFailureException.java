package functionalModule.id_generator;

/**
 * 自定义异常-id生成失败异常
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/9 8:41
 */
public class IdGenerationFailureException extends Exception{

    public IdGenerationFailureException(String message) {
        super(message);
    }
}

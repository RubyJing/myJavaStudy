package designpatterns.原型模式;

import javax.management.OperationsException;

/**
 * 实例创建失败异常
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/12 14:09
 */
public class InstanceCreateFailException extends OperationsException {

    public InstanceCreateFailException() {
    }

    public InstanceCreateFailException(String message) {
        super(message);
    }
}

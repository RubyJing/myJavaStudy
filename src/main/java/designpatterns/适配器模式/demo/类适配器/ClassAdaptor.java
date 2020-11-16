package designpatterns.适配器模式.demo.类适配器;

import designpatterns.适配器模式.demo.Adaptee;
import designpatterns.适配器模式.demo.ITarget;

/**
 * 类适配器：基于继承实现
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/16 10:42
 */
public class ClassAdaptor extends Adaptee implements ITarget {
    @Override
    public void f1() {
        super.fa();
    }

    @Override
    public void f2() {
        //重新实现f2接口
        System.out.println("f2");
    }

    //这里fc()不需要实现，直接继承。这是对象适配器最大的不同点
}

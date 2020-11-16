package designpatterns.适配器模式.demo.对象适配器;

import designpatterns.适配器模式.demo.Adaptee;
import designpatterns.适配器模式.demo.ITarget;


/**
 * 对象适配器:基于实现接口实现
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/16 10:44
 */
public class ObjectAdaptor implements ITarget {

    private Adaptee adaptee;

    public ObjectAdaptor(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void f1() {
        adaptee.fa();
    }

    @Override
    public void f2() {
        //重新实现f2接口
        System.out.println("f2");
    }

    @Override
    public void fc() {
        adaptee.fc();
    }
}

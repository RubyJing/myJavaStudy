package designpatterns.装饰模式;

/**
 * 人
 */
public abstract class Person {
    abstract void show();

    abstract void say();

    void walk(){
        System.out.println("走路");
    }
}

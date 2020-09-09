package designpatterns.装饰模式;

/**
 * 具体服饰类（ConcreteDecorator）:球鞋
 */
public class Sneakers extends Finery {
    public Sneakers(Person component) {
        super(component);
    }

    @Override
    public void show(){
        System.out.println("球鞋");
    }

}

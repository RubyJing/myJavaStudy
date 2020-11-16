package designpatterns.装饰模式;

/**
 * 具体服饰类（ConcreteDecorator）:T恤
 */

public class Tshirts extends Finery {

    public Tshirts(Person component) {
        super(component);
    }

    @Override
    public void show(){
        System.out.println("大T恤");
    }
}


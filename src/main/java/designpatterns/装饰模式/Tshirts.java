package designpatterns.装饰模式;

/**
 * 具体服饰类（ConcreteDecorator）:T恤
 */

public class Tshirts extends Finery {
    @Override
    public void Show(){
        System.out.println("大T恤");
        component.Show();
    }
}


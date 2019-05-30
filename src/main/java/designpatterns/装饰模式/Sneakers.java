package designpatterns.装饰模式;

/**
 * 具体服饰类（ConcreteDecorator）:球鞋
 */
public class Sneakers extends Finery {
    @Override
    public void Show(){
        System.out.println("球鞋");
        component.Show();
    }
}

package designpatterns.装饰模式;

/**
 * 具体服饰类（ConcreteDecorator）:大裤子
 */
class BigTrouser extends Finery{
    @Override
    public void Show(){
        System.out.println("大裤子");
        component.Show();
    }
}

package designpatterns.装饰模式;

/**
 * 具体服饰类（ConcreteDecorator）:大裤子
 */
class BigTrouser extends Finery{
    public BigTrouser(Person component) {
        super(component);
    }

    @Override
    public void show(){
        System.out.println("大裤子");
    }
}

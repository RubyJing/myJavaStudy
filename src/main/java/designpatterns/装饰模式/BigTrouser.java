package designpatterns.装饰模式;

/**
 * 具体服饰类（ConcreteDecorator）:大裤子
 */
class BigTrouser extends Finery{
    public BigTrouser(Person component) {
        super(component);
    }

    public void showPant(){
        System.out.println("穿大裤子");
    }
}

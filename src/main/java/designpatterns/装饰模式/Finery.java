package designpatterns.装饰模式;

/**
 * 服饰类（Decorator)
 */
public class Finery extends FilterPerson{

    public Finery(Person component) {
        super(component);
    }

    @Override
    public void show(){
        super.show();
    }

}

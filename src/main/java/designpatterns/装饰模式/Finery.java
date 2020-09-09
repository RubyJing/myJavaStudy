package designpatterns.装饰模式;

/**
 * 服饰类（Decorator)
 */
public class Finery extends Person{
    protected Person component;

    public Finery(Person component) {
        this.component = component;
    }

    @Override
    public void show(){
        if(component != null){
            component.show();
        }
    }

}

package designpatterns.装饰模式;

/**
 * 服饰类（Decorator)
 */
public abstract class Finery extends Person{
    protected Person component;

    public void Decorate(Person component){
        this.component = component;
    }

    @Override
    public void Show(){
        if(component != null){
            component.Show();
        }
    }
}

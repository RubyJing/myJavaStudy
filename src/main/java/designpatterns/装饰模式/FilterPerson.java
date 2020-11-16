package designpatterns.装饰模式;

/**
 * 人过滤器类
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/16 9:47
 */
public class FilterPerson extends Person {

    protected Person person;

    public FilterPerson(Person person) {
        this.person = person;
    }

    @Override
    public void show() {
       person.show();
    }

    @Override
    public void say() {
        person.say();
    }
}

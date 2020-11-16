package designpatterns.装饰模式;

/**
 * 正常人
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/16 9:52
 */
public class NormalPerson extends Person {

    private String name;

    public NormalPerson(String name) {
        this.name = name;
    }

    @Override
    void show() {
        System.out.println("姓名:" + name);
    }

    @Override
    void say() {
        System.out.println(name + "说：");
    }
}

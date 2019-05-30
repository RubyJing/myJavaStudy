package designpatterns.装饰模式;

/**
 * 人
 */
public class Person {
    public Person() {
    }

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void Show(){
        System.out.println("装扮的人名："+name);
    }
}

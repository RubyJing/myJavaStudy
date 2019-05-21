package tips.对象克隆;

import java.io.Serializable;

/**
 * 人类
 * @author RubyJing
 */
public class Person implements Serializable {
    /** 姓名 **/
    private String name;
    /** 年龄 **/
    private int age;
    /** 汽车类 */
    private Car car;

    public Person(String name, int age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}

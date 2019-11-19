package tips.泛型;

/**
 * 类中的泛型方法
 * -->声明是泛型方法，类泛型和方法泛型互不影响
 * @Author RubyJing
 * @Date 2019/11/18 14:44
 * @Version 1.0
 */
public class MethodOnClass {

    public static void main(String[] args) {
        MethodOnClass methodOnClass = new MethodOnClass();
        Apple apple = methodOnClass.new Apple();
        Person person = methodOnClass.new Person();

        Test<Fruit> fruitTest = methodOnClass.new Test<>();
        //apple是Fruit的子类
        fruitTest.show_1(apple);
        //编译器报错
//        fruitTest.show_1(person);

        fruitTest.show_2(apple);
        fruitTest.show_2(person);

        fruitTest.show_3(apple);
        fruitTest.show_3(person);


    }

    class Fruit{
        @Override
        public String toString(){
            return "fruit";
        }
    }

    class Apple extends Fruit{
        @Override
        public String toString(){
            return "apple";
        }
    }

    class Person{
        @Override
        public String toString(){
            return "Person";
        }
    }

    class Test<T>{
        //使用的泛型类的类型
        public void show_1(T t){
            System.out.println(t.toString());
        }

        //在泛型类中声明一个泛型方法，使用泛型E，
        // 这种泛型E可以为任意类型,可以与类型T相同也可以不同
        //由于泛型方法在声明的时候会声明泛型<E>，所以无论泛型类中有没有声明，都可以使用
        public <E> void show_3(E t){
            System.out.println(t.toString());
        }

        //在泛型类中声明了一个泛型方法，使用泛型T，注意这个T是一种全新的类型，和泛型类无关
        public <T> void show_2(T t){
            System.out.println(t.toString());
        }
    }

}

package designpatterns.装饰模式;

public class Test {
    public static void main(String[] args) {
        Person person = new Person("小明");
        System.out.println("第一种装扮：");
        Sneakers sneakers = new Sneakers(person);
        Tshirts tshirts = new Tshirts(sneakers);
        //装饰过程
        sneakers.say();
//        sneakers.Show();
        tshirts.show();

//        System.out.println("\n第二种装扮：");
//        BigTrouser bigTrouser = new BigTrouser();
//        //装饰过程
//        tshirts.Decorate(person);
//        bigTrouser.Decorate(tshirts);
//        sneakers.Decorate(bigTrouser);
//        sneakers.Show();
    }
}

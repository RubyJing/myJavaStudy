package designpatterns.装饰模式;

public class Test {
    public static void main(String[] args) {
        Person person = new Person("小明");
        System.out.println("第一种装扮：");
        Sneakers sneakers = new Sneakers();
        Tshirts tshirts = new Tshirts();
        //装饰过程
        tshirts.Decorate(person);
        sneakers.Decorate(tshirts);
        sneakers.Show();

        System.out.println("\n第二种装扮：");
        BigTrouser bigTrouser = new BigTrouser();
        //装饰过程
        tshirts.Decorate(person);
        bigTrouser.Decorate(tshirts);
        sneakers.Decorate(bigTrouser);
        sneakers.Show();
    }
}

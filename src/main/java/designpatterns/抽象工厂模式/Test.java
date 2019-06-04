package designpatterns.抽象工厂模式;

public class Test {
    public static void main(String[] args) {
//        LeiFeng leiFeng = new Undergraduate();
//        leiFeng.BuyRice();
//        leiFeng.Sweep();
//        leiFeng.Wash();
        //简单工厂模式:3个学生做不同的事情
        LeiFeng studentA = SimpleFactory.CreateLeiFeng("学雷锋的大学生");
        studentA.Wash();
        LeiFeng studentB = SimpleFactory.CreateLeiFeng("学雷锋的大学生");
        studentB.Sweep();
        LeiFeng studentC = SimpleFactory.CreateLeiFeng("学雷锋的大学生");
        studentC.BuyRice();

        //工厂方法模式（抽象工厂）
        IFactory factory = new UndergraduateFactory();
        LeiFeng student = factory.CreateLeiFeng();
        student.BuyRice();
        student.Sweep();
        student.Wash();
    }
}

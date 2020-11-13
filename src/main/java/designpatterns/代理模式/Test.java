package designpatterns.代理模式;

public class Test {
    public static void main(String[] args) {
        SchoolGirl jiaojiao = new SchoolGirl();
        jiaojiao.setName("娇娇");

        //普通代理
        PursuitProxy pursuitProxy = new PursuitProxy(jiaojiao);
        pursuitProxy.GiveDolls();
        pursuitProxy.GiveFlowers();
        pursuitProxy.GiveChocolate();

        //动态代理
        Pursuit pursuit = new Pursuit(jiaojiao);

        Gift gift = (Gift)DynamicProxy.create(pursuit);
        gift.GiveDolls();

        GiveGift giveGift = (GiveGift)DynamicProxy.create(pursuit);
        giveGift.GiveFlowers();
        giveGift.GiveChocolate();
        giveGift.GiveDolls();

        IPursuitController pursuitController = (IPursuitController) DynamicProxy.create(new PursuitController(pursuit));
        pursuitController.pursuit();

        //错误示范，要使用接口  ClassCastException
//        PursuitController pursuitController = (PursuitController)DynamicProxy.create(new PursuitController(pursuit));
//        pursuitController.pursuit();


    }
}

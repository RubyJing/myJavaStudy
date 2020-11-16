package designpatterns.装饰模式;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        Person person = new Sneakers(new NormalPerson("虾米"));
        Tshirts tshirts = new Tshirts(person);
        BigTrouser bigTrouser = new BigTrouser(tshirts);
        //装饰过程
        bigTrouser.show(); //BigTrouser中没有实现，调用Tshirts的方法
        bigTrouser.say(); // BigTrouser中没有实现，调用的NormalPerson的方法
        bigTrouser.walk(); // BigTrouser中没有实现，调用Person的方法
        bigTrouser.showPant(); // BigTrouser有实现



//
//        InputStream in = new FileInputStream("D:\\myprojcet\\myJavaStudy\\src\\main\\java\\designpatterns\\装饰模式\\test.txt");
//        InputStream bin = new BufferedInputStream(in);
//        DataInputStream din = new DataInputStream(in);
//        int data = din.readInt();
    }
}

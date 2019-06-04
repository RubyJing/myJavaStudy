package designpatterns.原型模式;

public class Test {
    public static void main(String[] args) {
        Resume a = new Resume("大鸟");
        a.SetPersonalInfo("男","29");
        a.SetWorkExperience("1998-2000","XX公司");

        Resume b = (Resume)a.Clone();
        b.SetWorkExperience("1998-2006","YY企业");

        Resume c = (Resume)a.Clone();
        c.SetWorkExperience("1998-2003","zz企业");

        a.Display();
        b.Display();
        c.Display();
    }
}

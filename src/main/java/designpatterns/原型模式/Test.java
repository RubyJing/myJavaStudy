package designpatterns.原型模式;


import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
//        Resume a = new Resume("大鸟");
//
//        Resume b = (Resume) a.shallowClone();
//        b.SetWorkExperience("1998-2006", "YY企业");
////        b.SetWorkExperience(null,null);
//
//        // 深拷贝：完全独立的对象
//        Resume c = (Resume) a.deepClone();
//        c.SetWorkExperience("1998-2003", "zz企业");
//
//        a.Display();
//        b.Display();
//        c.Display();

        HashMap<String, PrototypeDemo.SearchWord> oldMap = new HashMap<>();
        PrototypeDemo.SearchWord searchWord = new PrototypeDemo.SearchWord("1", 12121, 1111111);
        oldMap.put("1", searchWord);
        oldMap.put("2", new PrototypeDemo.SearchWord("2", 23456, 2111111));

        //浅拷贝
        HashMap<String, PrototypeDemo.SearchWord> newMap = (HashMap<String, PrototypeDemo.SearchWord>) oldMap.clone();

//        newMap.remove("2");
        newMap.put("1",new PrototypeDemo.SearchWord("2", 23456, 461312310));
        searchWord.setLastUpdateTime(78121512);

        System.out.println(oldMap.toString());
        System.out.println(newMap.toString());


    }
}

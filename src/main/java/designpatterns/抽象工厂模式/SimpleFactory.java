package designpatterns.抽象工厂模式;

/**
 * 简单雷锋工厂
 */
public class SimpleFactory {
    public static LeiFeng CreateLeiFeng(String type){
        LeiFeng result = null;
        switch (type){
            case "学雷锋的大学生":
                result = new Undergraduate();
                break;
            case "社会志愿者":
                result = new Volunteer();
                break;
        }
        return result;
    }
}

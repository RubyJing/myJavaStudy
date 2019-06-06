package designpatterns.模板方法模式;

/**
 * 问题类(模板)
 */
public class TestPaper {
    public void TestQuestion1(){
        System.out.println("这是一个问题，你选什么？");
        System.out.println("答案："+Answer1());
    }

    protected  String Answer1(){
        return "";
    }

    public void TestQuestion2(){
        System.out.println("这是第二个问题，你选什么？");
        System.out.println("答案："+Answer2());
    }

    protected  String Answer2(){
        return "";
    }

    public void TestQuestion3(){
        System.out.println("这是第三个问题，你选什么？");
        System.out.println("答案："+Answer3());
    }
    protected  String Answer3(){
        return "";
    }
}

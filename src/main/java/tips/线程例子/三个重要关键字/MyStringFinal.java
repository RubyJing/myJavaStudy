package tips.线程例子.三个重要关键字;

/**
 * final类型的类如何拓展?
 * 比如String是final类型，我们想写个MyString复用所有String中方法，同时增加一个新的toMyString()的方法，应该如何做?
 *
 * 设计模式--组合实现
 * @author RubyJing
 * @version 1.0
 * @date 2020/9/8 9:05
 */
public class MyStringFinal {

    private String innerString;



    //支持老的方法

    public int length(){
        return innerString.length();
    }

    //添加新的方法

    public String toMyString(){
        return "to";
    }
}

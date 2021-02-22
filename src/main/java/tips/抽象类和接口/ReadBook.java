package tips.抽象类和接口;

/**
 * @author RubyJing
 */
public interface ReadBook  {
    int a = 0;

    /**
     * 发现书
     *
     * @param type 类型
     * @return 书名
     */
    String findBook(String type);

    /**
     * 获取书
     */
    String getBook();
}

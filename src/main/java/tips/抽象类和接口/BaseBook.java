package tips.抽象类和接口;

/**
 * @author RubyJing
 */
public abstract class BaseBook implements ReadBook{

    private String size;
    private String name;
    private String price;

    public int param3;
    int param = 2;
    public int param2 = 3;

    protected BaseBook(String size, String name, String price) {
        this.size = size;
        this.name = name;
        this.price = price;
    }

    public BaseBook() {

    }


    public String hello(String name) {
        this.name = name;
        System.out.println("hello" + name);
        return name;
    }

    /**
     * 获取大小
     */
   public abstract String getSize(String name);

    /**
     * 获取书
     */
    @Override
    public String getBook() {
        System.out.println("baseBook");
        return "dadaBook";
    }

    @Override
    public String findBook(String type) {
        System.out.println(type);
        return type;
    }

}

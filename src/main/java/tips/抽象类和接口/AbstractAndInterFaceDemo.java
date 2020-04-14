package tips.抽象类和接口;

/**
 * @author RubyJing
 */
public class AbstractAndInterFaceDemo extends BaseBook implements ReadBook {

    @Override
    public String getSize(String name) {
        System.out.println(name);
        return name;
    }


    @Override
    public String getBook() {
        System.out.println("book");
        return "book";
    }

}

class Test {
    public static void main(String[] args) {
        //都不能实例化
        BaseBook baseBook = new BaseBook() {
            @Override
            public String getSize(String name) {
                return null;
            }
        };
        ReadBook readBook = new ReadBook() {
            @Override
            public String findBook(String type) {
                return null;
            }

            @Override
            public String getBook() {
                return null;
            }
        };

        BaseBook baseBook2 = new AbstractAndInterFaceDemo();
        baseBook2.getSize("好书");
        baseBook2.getBook();
        baseBook2.hello("java world");
        ReadBook readBook2 = new AbstractAndInterFaceDemo();
        readBook2.findBook("悬疑");
        readBook2.getBook();

    }
}

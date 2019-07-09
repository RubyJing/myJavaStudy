package tips.构建简单链表;

public class Test {


    public static void main(String[] args) {
        List<String> list = new SimpleList<>(3);
        list.add("hello");
        System.out.println(list.get(0));
        System.out.println(list.contains("hello"));
    }
}

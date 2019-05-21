package tips.对象克隆;

public class CloneTest {

    public static void main(String[] args) {
        try {
            Person p1 = new Person("RubyJing",24,new Car("奥迪",300));
            //深度克隆
            Person p2 = MyUtil.clone(p1);
            // 修改克隆的Person对象p2关联的汽车对象的品牌属性
            // 原来的Person对象p1关联的汽车不会受到任何影响
            // 因为在克隆Person对象时其关联的汽车对象也被克隆了
            p2.getCar().setBrand("BYD");
            System.out.println(p1.getCar().getBrand());
            System.out.println(p2.getCar().getBrand());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

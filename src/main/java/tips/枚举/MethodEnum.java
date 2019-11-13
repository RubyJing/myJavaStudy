package tips.枚举;

/**
 * 枚举中使用方法,
 * enum实例序列的最后添加一个分号
 * @Author RubyJing
 * @Date 2019/11/13 11:41
 * @Version 1.0
 */
public enum MethodEnum {
    RED("红色", 1),
    GREEN("绿色", 2),
    WHITE("白色", 3),
    YELLO("黄色", 4);

    // 成员变量
    private String name;
    private int index;

    // 构造方法
    MethodEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法
    public static String getName(int index) {
        for (MethodEnum c : MethodEnum.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }
    //覆盖方法
    @Override
    public String toString() {
        return this.index+"_"+this.name;
    }

    // get set 方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
}

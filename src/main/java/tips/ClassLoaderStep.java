package tips;

/**
 * JAVA中静态块、静态变量加载顺序详解
 * step: 加载静态代码块（无论如何都会被先加载，不管调不调用类，且仅一次）
 * 静态方法、静态变量属于类
 * 实例：加载匿名函数——>加载构造函数
 */
/** 第一步，加载类 **/
public class ClassLoaderStep {
    public static void main(String[] args) {
//        run();
//        new ClassLoaderStep();
    }
    /** 第二步，加载静态代码块 **/
    static int num = 4;
    static {
        System.out.println("=================加载父类静态代码块==================="+num);
    }

    /** 常量，按照顺序加载 **/
    public int a = 5;

    /** 第三步，加载匿名函数 **/
    {
        num += 3;
        System.out.println("=================加载父类匿名函数==================="+a);
    }

    /** 第四步，加载构造函数 **/
    public ClassLoaderStep() {
        System.out.println("=================加载父类构造函数==================="+a);
    }


    /** 静态方法，被调用才加载 **/
    static void run()
    {
        System.out.println("=================加载父类静态方法===================");
    }


    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        ClassLoaderStep.num = num;
    }

    protected int getA() {
        return a;
    }

    void setA(int a) {
        this.a = a;
    }
}

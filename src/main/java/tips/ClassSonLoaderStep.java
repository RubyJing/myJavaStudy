package tips;

/**
 * 继承时，加载静态块、静态变量加载顺序详解
 * <p>
 * 加载静态代码块（无论如何都会被先加载，不管调不调用类，且仅一次）
 * --加载父类静态代码块(仅一次)——>加载子类静态代码块(仅一次)
 * 实例化子类时：加载匿名函数——>加载构造函数
 * step:——>加载父类匿名函数、构造函数——>加载子类匿名函数、构造函数
 * remark:静态代码块永远会执行，且只执行一次
 */
public class ClassSonLoaderStep extends ClassLoaderStep {
    public static void main(String[] args) {
        new ClassSonLoaderStep();
    }

    /**
     * 第二步，加载静态代码块
     **/
    static int num = 6;

    static {
        System.out.println("=================加载子类静态代码块===================" + num);
    }

    /**
     * 常量，按照顺序加载
     **/
    int a = 7;

    /** 第三步，加载匿名函数 **/ {
        num += 3;
        System.out.println("=================加载子类匿名函数===================" + a);
    }

    /**
     * 第四步，加载构造函数
     **/
    public ClassSonLoaderStep() {
        System.out.println("=================加载子类构造函数===================" + a);
    }


    /**
     * 静态方法，被调用才加载
     **/
    static void run() {
        System.out.println("=================加载子类静态方法===================");
    }
}

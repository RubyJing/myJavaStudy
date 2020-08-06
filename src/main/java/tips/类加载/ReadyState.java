package tips.类加载;

/**
 * 准备状态
 * @author RubyJing
 * @version 1.0
 * @date 2020/8/6 8:51
 */
public class ReadyState {

    /**
     * 被static final 修饰（常量）：必须在声明时显式地为其赋值
     */
    public static final int A_A = 7;

    /**
     * 被final修饰：既可以在声明时显式地为其赋值，也可以在类初始化时显式地为其赋值
     */
    public final int A_C;
    public ReadyState(int a_c) {
        A_C = a_c;
    }

    /**
     * 被static修饰：如果不显式地对其赋值而直接使用，则系统会为其赋予默认的零值
     */
    public static int A_B;
    /**
     * 类全局变量：如果不显式地对其赋值而直接使用，则系统会为其赋予默认的零值
     */
    private String name;



}

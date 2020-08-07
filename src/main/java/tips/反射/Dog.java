package tips.反射;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/8/6 13:54
 */
public class Dog extends Animal implements I1,I2 {
    private int mDogPrivate;
    public int mDogPublic;
    protected int mDogProtected;
    private int mDogDefault;

    private static int sDogPrivate;
    protected static int sDogProtected;
    static int sDogDefault;
    public static int sDogPublic;
}

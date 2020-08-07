package tips.反射;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/8/6 13:54
 */
public class Animal extends Cell {

    private int mAnimalPrivate;
    protected int mAnimalProtected;
    int mAnimalDefault;
    public int mAnimalPublic;

    private static int sAnimalPrivate;
    protected static int sAnimalProtected;
    static int sAnimalDefault;
    public static int sAnimalPublic;
}

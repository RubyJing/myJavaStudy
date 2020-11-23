package functionalModule.callback;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/23 10:54
 */
public class AClass {
    public static void main(String[] args) {
        //同步回调
        BClass b = new BClass();
        b.process(new ICallback() {
            @Override
            public void methodToCallback() {
                System.out.println("Call back me");
            }
        });
    }
}

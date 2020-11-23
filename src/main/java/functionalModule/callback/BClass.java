package functionalModule.callback;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/23 10:53
 */
public class BClass {
    public void process(ICallback callback){
        //...

        callback.methodToCallback();

        //...
    }
}

package tips;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 异常的try catch测试
 * @RubyJing
 */
class ExceptionA extends Exception{

}

class ExceptionB extends ExceptionA{

    public ExceptionB(String b) {
        super();
    }
    public ExceptionB() {
        super();
    }
}

public class tryCatchExceptionTest {
    public static void main(String[] args)throws Exception {
       /**
        * 一个基本例子
        * **/
        try {
            throw new ExceptionB("b");
        }catch (ExceptionB e){
            System.out.println("ExceptionB");
        } catch (ExceptionA e) {
           System.out.println("ExceptionA");
        }catch (Exception e){
            System.out.println("Exception");
        }


        /**
         * 一个复杂的例子
         */
        try {
            try {
                throw new ExceptionB();
            } catch (ExceptionA e) {
                System.out.println("Caught ExceptionA!");
                throw e;
            }
        }catch (ExceptionB e){
            System.out.println("Caught ExceptionB!");
        }finally {
            System.out.println("Hello World!");
        }

    }

}

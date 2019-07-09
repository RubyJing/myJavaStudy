package tips.Lambda表达式;

/**
 * Lambda表达式简单例子
 */
public class SimpleExample {
    MathOperation java7 = new MathOperation() {
        @Override
        public int operation(int a, int b) {
            return a+b;
        }
    };

    /** 类型声明 **/
    MathOperation addition = (int a,int b) -> a+b;

    /** 不用类型声明 **/
    MathOperation subtraction = (a,b) -> a-b;

    /** 大括号中的返回语句 **/
    MathOperation multiplication = (a,b) -> {return a*b;};

    /** 没用大括号及返回语句 **/
    MathOperation division = (int a,int b) -> a/b;

    private int operate(int a,int b,MathOperation mathOperation){
        return mathOperation.operation(a,b);
    }

    public static void main(String[] args) {
        SimpleExample simpleExample = new SimpleExample();
        System.out.println("10+5="+simpleExample.operate(10,5,simpleExample.addition));
        System.out.println("10-5="+simpleExample.operate(10,5,simpleExample.subtraction));
        System.out.println("10*5="+simpleExample.operate(10,5,simpleExample.multiplication));
        System.out.println("10/5="+simpleExample.operate(10,5,simpleExample.division));

        /** 不用括号 **/
        GreetingService greetingService = message ->
                System.out.println("Hello "+message);

        /** 用括号 **/
        GreetingService greetingService2 = (message) ->
                System.out.println("Hello "+message);

        greetingService.sayMessage("Runoob");
        greetingService2.sayMessage("Google");
    }


}

interface MathOperation{
    int operation(int a,int b);
}

interface GreetingService{
    void sayMessage(String message);
}

package tips;

/**
 * int类型相关tips
 * @author RubyJing
 */
public class SomeIntTips {
    public static void main(String[] args) {
        countTheNumberOfBits();
    }

    /**
     * 计算各个位的数
     */
    private static void countTheNumberOfBits(){
        int b = 56789;
        int ge = b % 10;
        int shi = b % 100 / 10;
        int bai = b % 1000 / 100;
        int qian = b % 10000 / 1000;
        int wan = b % 100000 / 10000;
        System.out.println("万" + wan + "千" + qian + "百" + bai + "十" + shi + "个" + ge);
    }
}

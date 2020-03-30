package tips.math包;

import java.util.Random;

/**
 * 随机数生成测试
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/3/30 10:57
 */
public class RandomTest {
    public static void main(String[] args) {
        RandomTest randomTest = new RandomTest();
        randomTest.sameResultForsameSeed(2*100000);
    }

    /**
     * 同样的种子导致同样的随机数
     * (同样的种子，生成随机数的顺序一样。如当前种子每次前5个都是2,6,6,0,5）
     *
     * note:java使用伪随机数，同一个随机数种子，生成的第N个生成的随机数一定是相同的 --》相对随机
     *       想完全随机，不要带种子参数，会以时间为种子
     *
     * @param seed 种子数
     */
    private void sameResultForsameSeed(int seed) {
        Random random = new Random(seed);
        for (int i = 0; i < 5 ; i++) {
            System.out.println(random.nextInt(10));
        }
    }
}

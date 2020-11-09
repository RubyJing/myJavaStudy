package functionalModule.id_generator;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * id生成器
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/5 14:25
 */
public class IdGenerator {

    public static void main(String[] args) {
        System.out.println(generate());
        System.out.println(generate());
        System.out.println(generate());
    }

    public static String generate() {
        String id = "";
        try {
            //bug:未处理hostName为空的情况
            String hostName = InetAddress.getLocalHost().getHostName();
            String[] tokens = hostName.split("\\.");
            if (tokens.length > 0) {
                hostName = tokens[tokens.length - 1];
            }
            char[] randomChars = new char[8];
            int count = 0;
            Random random = new Random();
            //算法可以优化
            //可用数字仅包含三段子区间（0~9，a~z，A~Z），
            // 极端情况下会随机生成很多三段区间之外的无效数字，需要循环很多次才能生成随机字符串
            while (count < 8) {
                int randomAscii = random.nextInt(122);
                if (randomAscii >= 48 && randomAscii <= 57) {
                    randomChars[count] = (char) ('0' + (randomAscii - 48));
                    count++;
                } else if (randomAscii >= 65 && randomAscii <= 90) {
                    randomChars[count] = (char) ('A' + (randomAscii - 65));
                    count++;
                } else if (randomAscii >= 97 && randomAscii <= 122) {
                    randomChars[count] = (char) ('a' + (randomAscii - 97));
                    count++;
                }
            }
            id = String.format("%s-%d-%s", hostName,
                    System.currentTimeMillis(), new String(randomChars));
        } catch (UnknownHostException e) {
            //bug: 异常没有抛出，而且内部处理了
            e.printStackTrace();
        }
        return id;
    }
}

package functionalModule.id_generator;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Id生成器：使用生成随机值生成id
 *
 * <p>
 * 这个ids生成不是唯一的，但是可能重复的概率非常低
 * </p>
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/6 10:56
 */
public class RandomIdGenerator implements LogTraceIdGenerator {

    public static final Logger logger = Logger.getLogger(RandomIdGenerator.class.getSimpleName());


    /**
     * 生成随机ID。
     * 只会在很少的情况下会有重复
     *
     * @return 一个随机id
     */
    @Override
    public String generate() throws IdGenerationFailureException {
        String substrOfHostName;
        try {
            substrOfHostName = getLastFieldOfHostName();
        } catch (UnknownHostException e) {
            throw new IdGenerationFailureException("host name is empty.");
        }
        long currentTimeMillis = System.currentTimeMillis();
        String randomString = generateRandomAlphameric(8);
        return String.format("%s-%d-%s",
                substrOfHostName, currentTimeMillis, randomString);
    }

    /**
     * 获取本地的主机名
     * 另外，用“.”来分割主机名，并获取最后一个
     *
     * @return 主机名的最后一个字段。如果未获得主机名，则返回null。
     */
    private String getLastFieldOfHostName() throws UnknownHostException {
        String substrOfHostName;
        String hostName = InetAddress.getLocalHost().getHostName();
        if (hostName == null || hostName.isEmpty()) {
            throw new UnknownHostException("...");
        }
        substrOfHostName = getLastSubstrSplittedByDot(hostName);
        return substrOfHostName;
    }

    /**
     * 获取{@hostName}的最后一个由定界符'.'分隔的字段。
     *
     * @param hostName 主机名应该不为空
     * @return 返回{@hostName}的最后一个由定界符'.'分隔的字段
     * 如果 {@hostName}是空，返回的也是空
     */
    @VisibleForTesting
    protected String getLastSubstrSplittedByDot(String hostName) {
        if (hostName == null || "".equals(hostName)) {
            throw new IllegalArgumentException("...");
        }

        String[] tokens = hostName.split("\\.");
        return tokens[tokens.length - 1];
    }

    /**
     * 生成随机字符串。仅仅包含数字，大小写字母
     *
     * @param length 长度，至少是0
     * @return 返回一个长度是{@length}的由数字、大小写字母组成的字符串。
     * 如果是传入0，返回"";
     */
    @VisibleForTesting
    protected String generateRandomAlphameric(int length) {
        if (length < 0) {
            throw new IllegalArgumentException();
        }
        char[] randomChars = new char[length];
        int count = 0;
        Random random = new Random();
        while (count < length) {
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii);
            boolean idDigit = randomAscii >= '0' && randomAscii <= '9';
            boolean idUppercase = randomAscii >= 'A' && randomAscii <= 'Z';
            boolean idLowercase = randomAscii >= 'a' && randomAscii <= 'z';
            if (idDigit || idUppercase || idLowercase) {
                randomChars[count] = (char) randomAscii;
                ++count;
            }
        }
        return new String(randomChars);
    }
}

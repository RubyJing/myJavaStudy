package arithmetic;

import java.util.Arrays;

/**
 * String 字符串题库
 *
 * @author RubyJing
 * @version 1.0
 * @date 2021/3/17 13:56
 */
public class StringTitle {

    public static void main(String[] args) {
        StringTitle stringTitle = new StringTitle();
        System.out.println(stringTitle.replaceSpace("avc cs as"));
    }

    /**
     * 剑指Offer 05.替换空格
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.2 MB, 在所有 Java 提交中击败了73.51%的用户
     */
    public String replaceSpace(String s) {
//        return s.replaceAll(" ", "%20");  // 最简单的方式，效率不高
        char[] chars = s.toCharArray();
        StringBuilder newString = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == ' ') {
                newString.append("%20");
            } else {
                newString.append(aChar);
            }
        }
        return newString.toString();
    }

    /**
     * 官方方案
       剑指Offer 05.替换空格
       请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
      * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
      * 内存消耗：36.2 MB, 在所有 Java 提交中击败了82.05%的用户
     */
    public String replaceSpaceOfficial(String s) {
        char[] chars = s.toCharArray();
        char[] newChars = new char[chars.length * 3];
        int size = 0;
        for (char aChar : chars) {
            if (aChar == ' ') {
                newChars[size++] = '%';
                newChars[size++] = '2';
                newChars[size++] = '0';
            } else {
                newChars[size++] = aChar;
            }
        }
        return new String(newChars, 0, size);
    }

}

package tips.正则表达式;

import java.awt.*;
import java.util.regex.Pattern;

/**
 * 证件类型匹配训练
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/3/24 10:04
 */
public class CardRegTest {

    public static void main(String[] args) {
        System.out.println(validTaiWanPermit("23456789"));
    }

    /**
     * 匹配的台湾居民来往内地通行证（台胞证）
     * 有3种版本：
     * (老版本)首字母+9位数字
     * (近几年的版本）数字8位
     * (最新的版本) 数字18位
     *
     * @param cardNum 台胞证号码
     * @return true 符合，false 不符合
     */
    private static boolean validTaiWanPermit(String cardNum) {
        String regular = "^[A-Z]\\d{9}|\\d{8}|\\d{18}";
        return cardNum.matches(regular);
    }

    /**
     * 匹配的港澳居民来往内地通行证（回乡证）
     * （规则：11位，第1位位字母，“H”开头发给香港居民，“M”开头发给澳门居民，第2位至第11位是数字。
     * 前8位是通行证持有人的终身号，后2位数字表示换证次数)--存在不填写后2位的情况
     *
     * @param cardNum 回乡证号码
     * @return true 符合，false 不符合
     */
    private static boolean validHomecomingPermit(String cardNum) {
        String regular = "^[HM](\\d{10}|\\d{8})";
        return cardNum.matches(regular);
    }

    /**
     * 匹配的德国护照
     * （规则：9 个字符，由 2-3 个数字与 6-7 个字母混排，头尾是字母。或者单纯为 9 个数字)
     *
     * @param passport 护照号
     * @return true 符合，false 不符合
     */
    private static boolean validGermanyPassport(String passport) {
        String regular = "^[a-zA-Z][a-zA-Z0-9]{7}[a-zA-Z]|\\d{9}";
        return passport.matches(regular);
    }

    /**
     * 匹配加拿大护照（规则：2个字母加6个数字)
     *
     * @param passport 护照号
     * @return true 符合，false 不符合
     */
    private static boolean validCanadaPassport(String passport) {
        String regular = "^[a-zA-Z]{2}\\d{6}";
        return passport.matches(regular);
    }

    /**
     * 匹配美国/英国护照（规则：9位数字)
     *
     * @param passport 护照号
     * @return true 符合，false 不符合
     */
    private static boolean validUsaAndUkPassport(String passport) {
        String regular = "^\\d{9}";
        return passport.matches(regular);
    }
}

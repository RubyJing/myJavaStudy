package tips.正则表达式;


/**
 * 证件类型匹配训练
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/3/24 10:04
 */
public class CardRegTest {

    public static void main(String[] args) {
        System.out.println(validMacao("1234567(2)"));
//        System.out.println(numberToLetter(3));
    }


    /**
     * 匹配澳门身份证
     * 澳门身份证号码由8个拉丁数字组成，格式为：XNNNNNN(Y)。其中：
     * 第一位X，可能是1、5、7。绝大多数人以1字开首；以5字开首的身份证号码代表持有或曾经持有葡萄牙国民身份证或葡萄牙给外国人身份证之人士；以7字开首代表曾经取得蓝卡之人士，大多都是在1970年代至1980年代期间从中国大陆持合法证件到澳门的人士。
     * 最后一位Y，是查核用数字，是为方便电脑处理资料及检查号码输入的正确性而设。
     * 中间6位数字，是发证当局给出的顺序号。
     * @param idCard 证件号码
     * @return true 符合，false 不符合
     */
    public static boolean validMacao(String idCard){
        String regular = "\\d{7}\\(\\d\\)";
        return idCard.matches(regular);
    }

    /**
     * 数字转字母 1-26 ： A-Z
     *
     * @param num
     * @return
     */
    private static String numberToLetter(int num) {
        if (num <= 0) {
            return null;
        }
        String letter = "";
        num--;
        do {
            if (letter.length() > 0) {
                num--;
            }
            letter = ((char) (num % 26 + (int) 'A')) + letter;
            num = ((num - num % 26) / 26);
        } while (num > 0);

        return letter;
    }

    /**
     * 字母转数字
     *
     * @param letter 字母
     * @return 数字
     */
    private static int letterToNumber(String letter) {
        int length = letter.length();
        int num;
        int number = 0;
        for (int i = 0; i < length; i++) {
            char ch = letter.charAt(length - i - 1);
            num = ch - 'A' + 1;
            num *= Math.pow(26, i);
            number += num;
        }
        return number;
    }

    /**
     * 匹配香港身份证
     * 首字母+6位数字+(校验码)
     * 由前7位确定，首位字母改为数字代表，即A以1代表，B以2代表...Z以26代表，可以得到7个数字，之后第一个数字乘以8，第二个数字乘以7，依此类推，第七个数字乘以2
     * 再将以上所有乘积相加，得到一个数，再将这个数除以11，得到余数。如果整除，校验码为0，如果余数为1，则校验码为A，如果余数为2～10，则用11减去这个余数，则为校验码。
     *
     * @param idCard 证件号码
     * @return true 符合，false 不符合
     */
    private static boolean validHongKongIdcard(String idCard) {
        idCard = idCard.replace("（", "(").replace("）", ")");
        String regular = "^[A-Z]\\d{6}\\(([A-Z]|\\d)\\)";
        if (idCard.matches(regular)) {
            //截取第一位
            String letter = String.valueOf(idCard.charAt(0));
            int sum = letterToNumber(letter) * 8;
            int mulNum = 7;
            for (int i = 1; i < 7; i++) {
                int num = Integer.parseInt(String.valueOf(idCard.charAt(i)));
                sum += num * mulNum;
                mulNum--;
            }
            //获取真正的验证码
            int reminder = sum % 11;
            String verificationCode;
            if (reminder == 0) {
                verificationCode = "0";
            } else if (reminder == 1) {
                verificationCode = "A";
            } else {
                verificationCode = String.valueOf(11 - reminder);
            }
            //获取输入的验证码
            String code = idCard.substring(8, 9);
            return code.equals(verificationCode) || code.equals(numberToLetter(Integer.parseInt(verificationCode)));
        }
        return false;
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

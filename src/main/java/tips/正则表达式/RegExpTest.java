package tips.正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 * 从字符串中截取第一个英文左括号之前的字符串
 * 例如：北京市(朝阳区)(西城区)(海淀区)，截取结果为：北京市
 * @author RubyJing
 */
public class RegExpTest {
    public static void main(String[] args) {
        String str = "北京市(朝阳区)(西城区)(海淀区)";
        Pattern p = Pattern.compile(".*?(?=\\()");
        Matcher m = p.matcher(str);
        if(m.find()){
            System.out.println(m.group());
        }
    }
}

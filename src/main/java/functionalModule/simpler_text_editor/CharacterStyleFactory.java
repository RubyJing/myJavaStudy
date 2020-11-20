package functionalModule.simpler_text_editor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 文字样式生成工厂
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/20 11:11
 */
public class CharacterStyleFactory {
    private static final List<CharacterStyle> styles = new ArrayList<>();

    public static CharacterStyle getStyle(Font font, int size, int colorRGB) {
        CharacterStyle newStyle = new CharacterStyle(font, size, colorRGB);
        for (CharacterStyle style : styles) {
            if (style.equals(newStyle)) {
                return style;
            }
        }
        styles.add(newStyle);
        return newStyle;
    }
}

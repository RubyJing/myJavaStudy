package functionalModule.simpler_text_editor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 文本编辑器
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/20 11:04
 */
public class Editor {
    private List<Character> chars = new ArrayList<>();

    public void appendCharacter(char c, Font font,int size,int colorRGB){
        Character character = new Character(c,CharacterStyleFactory.getStyle(font,size,colorRGB));
        chars.add(character);
    }
}

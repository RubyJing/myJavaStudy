package functionalModule.simpler_text_editor;


/**
 * 文字
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/20 11:03
 */
public class Character {
    private char c;

    private CharacterStyle characterStyle;

    public Character(char c, CharacterStyle characterStyle) {
        this.c = c;
        this.characterStyle = characterStyle;
    }
}

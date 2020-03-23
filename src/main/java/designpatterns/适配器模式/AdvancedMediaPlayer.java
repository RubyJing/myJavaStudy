package designpatterns.适配器模式;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/3/23 9:16
 */
public interface AdvancedMediaPlayer {
    void playVlc(String fileName);

    void playMp4(String fileName);
}

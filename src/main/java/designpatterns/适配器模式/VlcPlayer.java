package designpatterns.适配器模式;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/3/23 9:20
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file.name："+fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}

package designpatterns.适配器模式;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/3/23 16:30
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3","hello Mrs");
        audioPlayer.play("mp4","hello Mrs");
        audioPlayer.play("vlc","hello Mrs");
        audioPlayer.play("avi","hello Mrs");
    }
}

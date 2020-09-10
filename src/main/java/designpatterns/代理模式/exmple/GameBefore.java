package designpatterns.代理模式.exmple;

/**
 * 赛前方法
 * @author RubyJing
 * @version 1.0
 * @date 2020/9/10 16:26
 */
public interface GameBefore {

    /**
     * 打
     */
    void play();

    /**
     * 安全检查
     */
    void safeCheck();
}

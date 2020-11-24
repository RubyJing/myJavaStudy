package designpatterns.状态模式;

/**
 * 马里奥的状态
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/24 13:52
 */
public enum State {
    SMALL(0),
    SUPER(1),
    FIRE(2),
    CAPE(3)
    ;

    private int value;

    State(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

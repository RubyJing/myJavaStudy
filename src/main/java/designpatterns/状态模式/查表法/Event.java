package designpatterns.状态模式.查表法;

/**
 * 事件
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/24 14:24
 */
public enum Event {

    GOT_MUSHROOM(0),
    GOT_CAPE(1),
    GOT_FIRE(2),
    MET_MONSTER(3)
    ;
    private int value;

    Event(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

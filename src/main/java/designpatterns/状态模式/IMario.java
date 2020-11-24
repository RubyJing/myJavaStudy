package designpatterns.状态模式;

/**
 * 所有状态类的接口
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/24 14:51
 */
public interface IMario {
    State getName();

    //以下是定义的事件

    void obtainMushRoom(MarioStateMachine stateMachine);

    void obtainCape(MarioStateMachine stateMachine);

    void obtainFireFlower(MarioStateMachine stateMachine);

    void meetMonster(MarioStateMachine stateMachine);
}

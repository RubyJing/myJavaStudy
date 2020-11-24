package designpatterns.状态模式.查表法;

import designpatterns.状态模式.State;

/**
 * 查表法实现--马里奥状态机
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/24 14:25
 */
public class MarioStateMachine {

    private int score;
    private State currentState;

    public MarioStateMachine() {
        this.score = 0;
        this.currentState = State.SMALL;
    }

    private final static State[][] transitionTable = {
            {State.SUPER, State.CAPE, State.FIRE, State.SMALL},
            {State.SUPER, State.CAPE, State.FIRE, State.SMALL},
            {State.CAPE, State.CAPE, State.CAPE, State.SMALL},
            {State.FIRE, State.FIRE, State.FIRE, State.SMALL}
    };

    private final static int[][] transitionScoreTable = {
            {+100, +200, +300, 0},
            {0, +200, +300, -100},
            {0, 0, 0, -200},
            {0, 0, 0, -300}
    };

    private void executeEvent(Event event) {
        int currEvent = event.getValue();
        int currState = currentState.getValue();
        State transitionState = transitionTable[currState][currEvent];
        this.score += transitionScoreTable[currState][currEvent];
        this.currentState = transitionState;
    }

    /**
     * 获取蘑菇
     */
    public void obtainMushRoom() {
        executeEvent(Event.GOT_MUSHROOM);
    }

    /**
     * 获取披风
     */
    public void obtainCape() {
        executeEvent(Event.GOT_CAPE);
    }

    /**
     * 获取火花
     */
    public void obtainFireFlower() {
        executeEvent(Event.GOT_FIRE);
    }

    /**
     * 遇见怪物
     */
    public void meetMonster() {
        executeEvent(Event.MET_MONSTER);
    }

    public int getScore() {
        return score;
    }

    public State getCurrentState() {
        return currentState;
    }
}

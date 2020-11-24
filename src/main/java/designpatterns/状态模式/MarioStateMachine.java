package designpatterns.状态模式;

/**
 * 马里奥状态机
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/24 13:53
 */
public class MarioStateMachine {
    private int score;
    private IMario currentState;

    public MarioStateMachine() {
        this.score = 0;
        this.currentState = SmallMario.getInstance();
    }

    /**
     * 获取蘑菇
     */
    public void obtainMushRoom(){
        this.currentState.obtainMushRoom(this);
    }

    /**
     * 获取披风
     */
    public void obtainCape(){
        this.currentState.obtainCape(this);
    }

    /**
     * 获取火花
     */
    public void obtainFireFlower(){
        this.currentState.obtainFireFlower(this);
    }

    /**
     * 遇见怪物
     */
    public void meetMonster(){
        this.currentState.meetMonster(this);
    }



    public int getScore() {
        return score;
    }

    public IMario getCurrentState() {
        return currentState;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCurrentState(IMario currentState) {
        this.currentState = currentState;
    }
}

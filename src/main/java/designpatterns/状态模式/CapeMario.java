package designpatterns.状态模式;

/**
 * 有披风的马里奥
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/24 14:55
 */
public class CapeMario implements IMario {

    private static final CapeMario INSTANCE = new CapeMario();

    private CapeMario() {
    }

    public static CapeMario getInstance(){
        return INSTANCE;
    }

    @Override
    public State getName() {
        return State.CAPE;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {
        //do Nothing
    }

    @Override
    public void obtainCape(MarioStateMachine stateMachine) {
        //do Nothing
    }

    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {
        //do Nothing
    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(SmallMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 200);
    }
}

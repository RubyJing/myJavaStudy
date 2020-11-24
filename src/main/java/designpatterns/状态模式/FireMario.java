package designpatterns.状态模式;

/**
 * 火的马里奥
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/24 14:56
 */
public class FireMario implements IMario {

    private static final FireMario INSTANCE = new FireMario();

    private FireMario() {
    }

    public static FireMario getInstance(){
        return INSTANCE;
    }


    @Override
    public State getName() {
        return State.FIRE;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {
        //do nothing
    }

    @Override
    public void obtainCape(MarioStateMachine stateMachine) {
        //do nothing
    }

    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {
        //do nothing
    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(SmallMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 300);
    }
}

package designpatterns.状态模式;

/**
 * 大的马里奥
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/24 14:54
 */
public class SuperMario implements IMario {
    private static final SuperMario INSTANCE = new SuperMario();

    private SuperMario() {
    }

    public static SuperMario getInstance(){
        return INSTANCE;
    }

    @Override
    public State getName() {
        return State.SUPER;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {
        // do Nothing
    }

    @Override
    public void obtainCape(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(CapeMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 200);
    }

    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(FireMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 300);
    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(SmallMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() - 100);
    }
}

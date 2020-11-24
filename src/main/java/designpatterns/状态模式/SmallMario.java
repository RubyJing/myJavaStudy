package designpatterns.状态模式;

/**
 * 小马里奥
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/24 14:52
 */
public class SmallMario implements IMario {

    //优化-->设计成单例，不需要重复创建对象
    private static final SmallMario INSTANCE = new SmallMario();

    private SmallMario() {
    }

    public static SmallMario getInstance(){
        return INSTANCE;
    }

    @Override
    public State getName() {
        return State.SMALL;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(SuperMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 100);
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
        //do Nothing

    }
}

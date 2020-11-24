package designpatterns.状态模式;

import designpatterns.状态模式.查表法.MarioStateMachine;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/24 14:46
 */
public class MarioDemo {


    public static void main(String[] args) {
        //查表法
        MarioStateMachine marioStateMachine = new MarioStateMachine();
        marioStateMachine.obtainMushRoom();
        System.out.println(marioStateMachine.getScore());
        marioStateMachine.meetMonster();
        System.out.println(marioStateMachine.getScore());
        //状态方法
        designpatterns.状态模式.MarioStateMachine stateMachine = new designpatterns.状态模式.MarioStateMachine();
        stateMachine.obtainMushRoom();
        System.out.println(stateMachine.getScore());
        stateMachine.meetMonster();
        System.out.println(stateMachine.getScore());
    }
}

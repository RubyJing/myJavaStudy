package functionalModule.alert;

import functionalModule.alert.MsgSender;

import java.util.List;

/**
 * 手机消息发送
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/13 15:19
 */
public class TelephoneMsgSender implements MsgSender {

    private List<String> telephones;

    public TelephoneMsgSender(List<String> telephones) {
        this.telephones = telephones;
    }

    @Override
    public void send(String message) {
        System.out.println("TelephoneMsgSender：" + telephones.size() + "--" + message);
    }
}

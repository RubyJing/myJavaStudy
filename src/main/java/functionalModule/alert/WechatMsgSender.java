package functionalModule.alert;

import java.util.List;

/**
 * 微信发送
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/13 15:22
 */
public class WechatMsgSender implements MsgSender {

    private List<String> wechats;

    public WechatMsgSender(List<String> wechats) {
        this.wechats = wechats;
    }

    @Override
    public void send(String message) {
        System.out.println("WechatMsgSender：" + wechats.size() + "--" + message);
    }
}

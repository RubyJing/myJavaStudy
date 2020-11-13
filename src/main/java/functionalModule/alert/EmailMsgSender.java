package functionalModule.alert;

import java.util.List;

/**
 * 邮箱发送
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/13 15:21
 */
public class EmailMsgSender implements MsgSender {

    private List<String> emails;

    public EmailMsgSender(List<String> emails) {
        this.emails = emails;
    }


    @Override
    public void send(String message) {
        System.out.println("EmailMsgSender：" + emails.size() + "--" + message);
    }
}

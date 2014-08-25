package wechat4j.message;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import wechat4j.message.handler.ISendMessageHandler;
import wechat4j.message.handler.MessageOperatorFactory;
import wechat4j.message.handler.SendMessageHandler;

/**
 * SendMessageHandlerTest
 *
 * @author renbin.fang.
 * @date 2014/8/25.
 */
public class SendMessageHandlerTest {

    public static void main(String[] args) throws ConfigurationException {
        Message message = new Message(
                "toUserName",
                "fromUserName",
                "123123123",
                "text");

        ISendMessageHandler sendMessageHandler = MessageOperatorFactory.getSendMessageOperator();
        String replyXml = sendMessageHandler.generateTextMessage("test message", message);

        System.out.println(replyXml);
    }
}

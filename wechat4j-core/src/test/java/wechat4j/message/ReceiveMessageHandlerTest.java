package wechat4j.message;

import org.testng.annotations.Test;
import wechat4j.message.handler.AbstractReceiveMessageHandler;
import wechat4j.message.handler.MessageHandlerFactory;

import java.io.InputStream;

/**
 * ReceiveMessageHandlerTest
 *
 * @author renbin.fang.
 * @date 2014/8/27.
 */
public class ReceiveMessageHandlerTest {
    private static AbstractReceiveMessageHandler messageHandler = MessageHandlerFactory.getMessageHandler();

    @Test
    public void getTextMessageTest() {
        InputStream inputStream = getClass().getResourceAsStream("/recived-text-message.xml");
        TextMessage textMessage = messageHandler.getMessageFromInputStream(inputStream);

        System.out.println(textMessage.toString());
    }

    @Test
    public void getImageMessageTest() {
        InputStream inputStream = getClass().getResourceAsStream("/recived-image-message.xml");
        ImageMessage imageMessage = messageHandler.getMessageFromInputStream(inputStream);

        System.out.println(imageMessage.toString());
    }
}
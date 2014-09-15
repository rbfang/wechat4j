package wechat4j.message;

import org.testng.annotations.Test;
import wechat4j.message.handler.AbstractReceiveMessageHandler;
import wechat4j.message.handler.MessageHandler;
import wechat4j.message.handler.MessageHandlerFactory;

import java.io.InputStream;

/**
 * ReceiveMessageHandlerTest
 *
 * @author renbin.fang.
 * @date 2014/8/27.
 */
public class ReceiveMessageHandlerTest {
    private MessageHandler messageHandler = MessageHandlerFactory.getMessageHandler();

    @Test
    public void getTextMessageTest() {
        InputStream inputStream = getClass().getResourceAsStream("/recived-text-message.xml");
        Message textMessage = messageHandler.getMessage(inputStream);

        System.out.println(textMessage.toString());
    }

    @Test
    public void getImageMessageTest() {
        InputStream inputStream = getClass().getResourceAsStream("/recived-image-message.xml");
        Message imageMessage = messageHandler.getMessage(inputStream);

        System.out.println(imageMessage.toString());
    }
}
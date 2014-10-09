package wechat4j.message;

import org.testng.annotations.Test;
import wechat4j.message.handler.AbstractReceivingMessageHandler;
import wechat4j.message.handler.MessageHandler;
import wechat4j.message.handler.MessageHandlerFactory;

import java.io.InputStream;

/**
 * ReceiveMessageHandlerTest
 *
 * @author renbin.fang.
 * @date 2014/8/27.
 */
public class CommonMessageHandlerTest {
    private static final String handlerType = MessageHandlerFactory.HandlerType.COMMON.toString();
    private MessageHandler messageHandler = MessageHandlerFactory.getMessageHandler(handlerType);

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
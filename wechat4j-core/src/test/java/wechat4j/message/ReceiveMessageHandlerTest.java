package wechat4j.message;

import org.junit.Test;
import wechat4j.message.handler.ReceiveMessageHandler;

import java.io.InputStream;

/**
 * ReceiveMessageHandlerTest
 *
 * @author renbin.fang.
 * @date 2014/8/27.
 */
public class ReceiveMessageHandlerTest {

    @Test
    public void getTextMessageTest() {
        InputStream inputStream = getClass().getResourceAsStream("/recived-text-message.xml");

        ReceiveMessageHandler receiveMessageHandler = new ReceiveMessageHandler();
        TextMessage textMessage = receiveMessageHandler.getMessage(inputStream);

        System.out.println(textMessage.toString());
    }

    @Test
    public void getImageMessageTest() {
        InputStream inputStream = getClass().getResourceAsStream("/recived-image-message.xml");

        ReceiveMessageHandler receiveMessageHandler = new ReceiveMessageHandler();
        ImageMessage imageMessage = (ImageMessage) receiveMessageHandler.getMessage(inputStream);

        System.out.println(imageMessage.toString());
    }
}

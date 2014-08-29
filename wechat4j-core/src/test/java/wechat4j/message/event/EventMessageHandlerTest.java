package wechat4j.message.event;

import org.junit.Test;
import wechat4j.message.handler.AbstractReceiveMessageHandler;
import wechat4j.message.handler.EventMessageHandler;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author renbin.fang.
 * @date 2014/8/27.
 */
public class EventMessageHandlerTest {

    @Test
    public void getSubscribeMessage() throws IOException {
        AbstractReceiveMessageHandler messageHandler = new EventMessageHandler();

        InputStream inputStream = getClass().getResourceAsStream("/event-message.xml");

        EventMessage eventMessage = messageHandler.getMessage(inputStream);

        System.out.println(eventMessage.toString());
    }

    @Test
    public void getScanEventMessage() {
        AbstractReceiveMessageHandler messageHandler = new EventMessageHandler();
        InputStream inputStream = getClass().getResourceAsStream("/event-scan-message.xml");
        ScanEventMessage scanEventMessage = messageHandler.getMessage(inputStream);

        System.out.println(scanEventMessage.toString());
    }
}

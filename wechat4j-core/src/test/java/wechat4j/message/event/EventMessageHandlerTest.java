package wechat4j.message.event;

import org.testng.annotations.Test;
import wechat4j.message.handler.AbstractReceiveMessageHandler;
import wechat4j.message.handler.EventMessageHandler;

import java.io.InputStream;

/**
 * EventMessageHandlerTest
 *
 * @author renbin.fang.
 * @date 2014/8/27.
 */
public class EventMessageHandlerTest {

    @Test
    public void getSubscribeMessage() {
        AbstractReceiveMessageHandler messageHandler = new EventMessageHandler();
        InputStream inputStream = getClass().getResourceAsStream("/event/event-message.xml");
        EventMessage eventMessage = messageHandler.getMessage(inputStream);

        System.out.println(eventMessage.toString());
    }

    @Test
    public void getUnsubscribeMessage() {
        AbstractReceiveMessageHandler messageHandler = new EventMessageHandler();
        InputStream inputStream = getClass().getResourceAsStream("/event/event-unsubscribe-message.xml");
        EventMessage eventMessage = messageHandler.getMessage(inputStream);

        System.out.println(eventMessage.toString());
    }

    @Test
    public void getScanSubscribeEventMessage() {
        AbstractReceiveMessageHandler messageHandler = new EventMessageHandler();
        InputStream inputStream = getClass().getResourceAsStream("/event/event-scan-subscribe-message.xml");
        ScanEventMessage scanEventMessage = messageHandler.getMessage(inputStream);

        System.out.println(scanEventMessage.toString());
    }

    @Test
    public void getScanEventMessage() {
        AbstractReceiveMessageHandler messageHandler = new EventMessageHandler();
        InputStream inputStream = getClass().getResourceAsStream("/event/event-scan-message.xml");
        ScanEventMessage scanEventMessage = messageHandler.getMessage(inputStream);

        System.out.println(scanEventMessage.toString());
    }

    @Test
    public void getLocationEventMessage() {
        AbstractReceiveMessageHandler messageHandler = new EventMessageHandler();
        InputStream inputStream = getClass().getResourceAsStream("/event/event-location-message.xml");
        LocationEventMessage locationEventMessage = messageHandler.getMessage(inputStream);

        System.out.println(locationEventMessage.toString());
    }

    @Test
    public void getCustomMenuClickEventMessage() {
        AbstractReceiveMessageHandler messageHandler = new EventMessageHandler();
        InputStream inputStream = getClass().getResourceAsStream("/event/event-custom-menu-message.xml");
        CustomMenuEventMessage customMenuEventMessage = messageHandler.getMessage(inputStream);

        System.out.println(customMenuEventMessage.toString());
    }
}

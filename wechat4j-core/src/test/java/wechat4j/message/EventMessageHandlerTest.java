package wechat4j.message;

import org.testng.annotations.Test;
import wechat4j.message.event.CustomMenuEventMessage;
import wechat4j.message.event.EventMessage;
import wechat4j.message.event.LocationEventMessage;
import wechat4j.message.event.ScanEventMessage;
import wechat4j.message.handler.AbstractReceivingMessageHandler;
import wechat4j.message.handler.EventMessageHandler;

import java.io.InputStream;

/**
 * EventMessageHandlerTest
 *
 * @author renbin.fang.
 * @date 2014/8/27.
 */
public class EventMessageHandlerTest {
    private AbstractReceivingMessageHandler messageHandler = new EventMessageHandler();

    @Test
    public void getSubscribeMessage() {
        InputStream inputStream = getClass().getResourceAsStream("/event/event-message.xml");
        EventMessage eventMessage = messageHandler.getMessageFromInputStream(inputStream);

        System.out.println(eventMessage.toString());
    }

    @Test
    public void getUnsubscribeMessage() {
        InputStream inputStream = getClass().getResourceAsStream("/event/event-unsubscribe-message.xml");
        EventMessage eventMessage = messageHandler.getMessageFromInputStream(inputStream);

        System.out.println(eventMessage.toString());
    }

    @Test
    public void getScanSubscribeEventMessage() {
        InputStream inputStream = getClass().getResourceAsStream("/event/event-scan-subscribe-message.xml");
        ScanEventMessage scanEventMessage = messageHandler.getMessageFromInputStream(inputStream);

        System.out.println(scanEventMessage.toString());
    }

    @Test
    public void getScanEventMessage() {
        InputStream inputStream = getClass().getResourceAsStream("/event/event-scan-message.xml");
        ScanEventMessage scanEventMessage = messageHandler.getMessageFromInputStream(inputStream);

        System.out.println(scanEventMessage.toString());
    }

    @Test
    public void getLocationEventMessage() {
        InputStream inputStream = getClass().getResourceAsStream("/event/event-location-message.xml");
        LocationEventMessage locationEventMessage = messageHandler.getMessageFromInputStream(inputStream);

        System.out.println(locationEventMessage.toString());
    }

    @Test
    public void getCustomMenuClickEventMessage() {
        InputStream inputStream = getClass().getResourceAsStream("/event/event-custom-menu-message.xml");
        CustomMenuEventMessage customMenuEventMessage = messageHandler.getMessageFromInputStream(inputStream);

        System.out.println(customMenuEventMessage.toString());
    }
}

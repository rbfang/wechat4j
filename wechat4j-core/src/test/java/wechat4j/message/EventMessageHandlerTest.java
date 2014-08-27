package wechat4j.message;

import wechat4j.message.handler.EventMessageHandler;

import java.io.InputStream;

/**
 * @author renbin.fang.
 * @date 2014/8/27.
 */
public class EventMessageHandlerTest {
    public void getSubscribeMessage(){
        EventMessageHandler eventMessageHandler = new EventMessageHandler();

        InputStream inputstream = getClass().getResourceAsStream("/event-message.xml");

        eventMessageHandler.getMessage(inputstream);

    }
}

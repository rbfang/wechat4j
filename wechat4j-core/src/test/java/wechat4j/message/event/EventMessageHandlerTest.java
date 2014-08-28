package wechat4j.message.event;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import sun.applet.Main;
import wechat4j.message.handler.EventMessageHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/**
 * @author renbin.fang.
 * @date 2014/8/27.
 */
public class EventMessageHandlerTest {

    @Test
    public void getSubscribeMessage() throws IOException {
        EventMessageHandler eventMessageHandler = new EventMessageHandler();

        InputStream inputStream = ClassLoader.getSystemResourceAsStream("event-message.xml");

        StringWriter writer = new StringWriter();
        IOUtils.copy(inputStream, writer);


        System.out.println(writer);

        EventMessage eventMessage = eventMessageHandler.getMessage(inputStream);
    }
}

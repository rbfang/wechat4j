package wechat4j.message.handler;

import org.apache.commons.configuration.XMLConfiguration;
import wechat4j.message.Message;
import wechat4j.message.event.*;

import java.awt.*;
import java.io.InputStream;

/**
 * EventHandler
 *
 * @author renbin.fang.
 * @date 2014/8/27.
 */
public class EventMessageHandler extends AbstractReceiveMessageHandler {
    private XMLConfiguration xmlReader;

    private static final String clazz = "wechat4j.message.handler.EventMessageHandler";

    @Override
    protected XMLConfiguration getXmlReader() {
        if (xmlReader == null) {
            xmlReader = new XMLConfiguration();
        }

        return xmlReader;
    }


    @Override
    public <T> T getMessage(InputStream inputStream) {
        reloadInputStream(inputStream);

        EventMessage eventMessage = getEventMessageHeader();
        EventMessage message = getEventMessageFromXml(clazz, eventMessage.getEvent(), inputStream);

        return (T) message;
    }

    private EventMessage getEventMessage() {
        return new EventMessage(getMessageHeader(), xmlReader.getString("Event"));
    }

    /**
     * 关注事件
     *
     * @return
     */
    public EventMessage getSubscribeEventMessage() {
        return getEventMessage();
    }

    /**
     * 取消事件
     *
     * @param inputStream
     * @return
     */
    public EventMessage getUnsubscribeEventMessage(InputStream inputStream) {
        return getEventMessage();
    }


    /**
     * 扫描带参数二维码事件
     *
     * @param inputStream
     * @return
     */
    public ScanEventMessage getScanEventMessage(InputStream inputStream) {
        return new ScanEventMessage(getEventMessage(),
                xmlReader.getString("EventKey"),
                xmlReader.getString("Ticket"));
    }

    /**
     * 上报地理位置事件
     *
     * @param inputStream
     * @return
     */
    public LocationEventMessage getLocationEventMessage(InputStream inputStream) {
        return new LocationEventMessage(getEventMessage(),
                xmlReader.getDouble("Latitude"),
                xmlReader.getDouble("Longitude"),
                xmlReader.getDouble("Precision"));
    }

    /**
     * 自定义菜单事件：
     * 1、点击菜单拉取消息时的事件推送
     * 2、点击菜单跳转链接时的事件推送
     *
     * @param inputStream
     * @return
     */
    public CustomMenuEventMessage getClickEventMessage(InputStream inputStream) {
        return new CustomMenuEventMessage(getEventMessage(),
                xmlReader.getString("EventKey"));
    }
}

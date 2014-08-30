package wechat4j.message.handler;

import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.lang.StringUtils;
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
    private static XMLConfiguration xmlReader;

    @Override
    protected XMLConfiguration getXmlReader() {
        if (xmlReader == null) {
            xmlReader = new XMLConfiguration();
        }

        return xmlReader;
    }

    @Override
    protected String getClassName() {
        return getClass().getName();
    }

    /**
     * 关注事件
     */
    private EventMessage getSubscribeEventMessage(Message message) {
        EventMessage eventMessage = (EventMessage) message;

        if (StringUtils.equals(eventMessage.getEvent(), EventMessage.EventType.SUBSCRIBE.getValue())) {
            // 如果有eventKey，则这条消息为扫描订阅事件
            String eventKey = getXmlReader().getString("EventKey");
            if (StringUtils.isNotEmpty(eventKey)) {

                return getScanEventMessage(message);
            }
        }

        return eventMessage;
    }

    /**
     * 取消关注事件
     */
    private EventMessage getUnsubscribeEventMessage(Message message) {
        return (EventMessage) message;
    }


    /**
     * 扫描带参数二维码事件
     */
    private ScanEventMessage getScanEventMessage(Message message) {
        return new ScanEventMessage(getEventMessageHeader(getMessageHeader()),
                xmlReader.getString("EventKey"),
                xmlReader.getString("Ticket"));
    }

    /**
     * 上报地理位置事件
     */
    private LocationEventMessage getLocationEventMessage(Message message) {
        return new LocationEventMessage((EventMessage) message,
                xmlReader.getDouble("Latitude"),
                xmlReader.getDouble("Longitude"),
                xmlReader.getDouble("Precision"));
    }

    /**
     * 自定义菜单事件：
     * 1、点击菜单拉取消息时的事件推送
     */
    private CustomMenuEventMessage getClickEventMessage(Message message) {
        return new CustomMenuEventMessage((EventMessage) message,
                xmlReader.getString("EventKey"));
    }

    /**
     * 自定义菜单事件：
     * 2、点击菜单跳转链接时的事件推送
     */
    private CustomMenuEventMessage getViewEventMessage(Message message) {
        return new CustomMenuEventMessage((EventMessage) message,
                xmlReader.getString("EventKey"));
    }
}

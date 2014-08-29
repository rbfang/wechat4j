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
     *
     * @return
     */
    private EventMessage getSubscribeEventMessage(Message message) {
        return (EventMessage) message;
    }

    /**
     * 取消事件
     *
     * @return
     */
    private EventMessage getUnsubscribeEventMessage(Message message) {
        return (EventMessage) message;
    }


    /**
     * 扫描带参数二维码事件
     *
     * @return
     */
    private ScanEventMessage getScanEventMessage(Message message) {
        return new ScanEventMessage(getEventMessageHeader(getMessageHeader()),
                xmlReader.getString("EventKey"),
                xmlReader.getString("Ticket"));
    }

    /**
     * 上报地理位置事件
     *
     * @return
     */
    private LocationEventMessage getLocationEventMessage() {
        return new LocationEventMessage(getEventMessageHeader(getMessageHeader()),
                xmlReader.getDouble("Latitude"),
                xmlReader.getDouble("Longitude"),
                xmlReader.getDouble("Precision"));
    }

    /**
     * 自定义菜单事件：
     * 1、点击菜单拉取消息时的事件推送
     * 2、点击菜单跳转链接时的事件推送
     *
     * @return
     */
    private CustomMenuEventMessage getClickEventMessage() {
        return new CustomMenuEventMessage(getEventMessageHeader(getMessageHeader()),
                xmlReader.getString("EventKey"));
    }
}

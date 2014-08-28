package wechat4j.message.handler;

import org.apache.commons.configuration.XMLConfiguration;
import wechat4j.message.Message;
import wechat4j.message.event.*;

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
    public Message getMessage(InputStream inputStream) {
        return getEventMessage(inputStream);
    }

    public EventMessage getEventMessage(InputStream inputStream) {
        reloadInputStream(inputStream);

        return new EventMessage(getMessageHeader(), xmlReader.getString("Event"));
    }

    /**
     * 关注/取消事件
     *
     * @param inputStream
     * @return
     */
    private SubscibeEventMessage getSubscibeEventMessage(InputStream inputStream) {
        return new SubscibeEventMessage(getEventMessage(inputStream));
    }


    /**
     * 扫描带参数二维码事件
     *
     * @param inputStream
     * @return
     */
    private ScanEventMessage getScanEventMessage(InputStream inputStream) {
        return new ScanEventMessage(getEventMessage(inputStream),
                xmlReader.getString("EventKey"),
                xmlReader.getString("Ticket"));
    }

    /**
     * 上报地理位置事件
     *
     * @param inputStream
     * @return
     */
    private LocationEventMessage getLocationEventMessage(InputStream inputStream) {
        return new LocationEventMessage(getEventMessage(inputStream),
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
    private CustomMenuEventMessage getClickEventMessage(InputStream inputStream) {
        return new CustomMenuEventMessage(getEventMessage(inputStream),
                xmlReader.getString("EventKey"));
    }
}

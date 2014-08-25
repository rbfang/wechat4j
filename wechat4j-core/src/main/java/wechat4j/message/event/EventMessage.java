package wechat4j.message.event;

import wechat4j.message.Message;

import java.io.Serializable;

/**
 * Event message
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public class EventMessage extends Message implements Serializable {
    private String event;

    public EventMessage() {
    }

    public EventMessage(String event) {
        this.event = event;
    }

    public EventMessage(String toUserName, String fromUserName, String createTime, String msgType, String messageId, String event) {
        super(toUserName, fromUserName, createTime, msgType, messageId);
        this.event = event;
    }

    /**
     * Event type
     */
    public enum EventType {
        SUBSCRIBE("subscribe"), UNSUBSCRIBE("unsubscribe"),

        LOCATION("LOCATION"), CLICK("CLICK"),

        SCAN("SCAN");

        private String value;

        EventType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}

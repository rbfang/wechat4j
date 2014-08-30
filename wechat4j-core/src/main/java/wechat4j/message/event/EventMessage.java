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

    public EventMessage(Message message, String event) {
        super(message.getToUserName(), message.getFromUserName(), message.getCreateTime(), message.getMsgType());
        this.event = event;
    }

    /**
     * Event type
     */
    public enum EventType {
        SUBSCRIBE("subscribe"), UNSUBSCRIBE("unsubscribe"),

        SCAN("SCAN"),

        LOCATION("LOCATION"),

        CLICK("CLICK"), VIEW("VIEW");

        private String value;

        EventType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public void setMessage(Message message) {
        super.setToUserName(message.getToUserName());
        super.setFromUserName(message.getFromUserName());
        super.setCreateTime(message.getCreateTime());
        super.setMsgType(message.getMsgType());
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "EventMessage{" +
                "event='" + event + '\'' +
                "} " + super.toString();
    }
}

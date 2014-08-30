package wechat4j.message.event;

import wechat4j.message.Message;

/**
 * CustomMenuEventMessage
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public class CustomMenuEventMessage extends EventMessage {
    private String eventKey;

    public CustomMenuEventMessage() {
    }

    public CustomMenuEventMessage(String eventKey) {
        this.eventKey = eventKey;
    }

    public CustomMenuEventMessage(String event, String eventKey) {
        super(event);
        this.eventKey = eventKey;
    }

    public CustomMenuEventMessage(EventMessage eventMessage, String eventKey) {
        super(new Message(eventMessage.getToUserName(), eventMessage.getFromUserName(), eventMessage.getCreateTime(), eventMessage.getMsgType()), eventMessage.getEvent());

        this.eventKey = eventKey;
    }

    @Override
    public String toString() {
        return "CustomMenuEventMessage{" +
                "eventKey='" + eventKey + '\'' +
                "} " + super.toString();
    }
}

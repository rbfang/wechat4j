package wechat4j.message.event;

/**
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public class CustomMenuEventMessage extends EventMessage {
    private String eventKey;

    public CustomMenuEventMessage(String eventKey) {
        this.eventKey = eventKey;
    }

    public CustomMenuEventMessage(String event, String eventKey) {
        super(event);
        this.eventKey = eventKey;
    }

    public CustomMenuEventMessage(String toUserName, String fromUserName, String createTime, String msgType, String messageId, String event, String eventKey) {
        super(toUserName, fromUserName, createTime, msgType, messageId, event);
        this.eventKey = eventKey;
    }
}

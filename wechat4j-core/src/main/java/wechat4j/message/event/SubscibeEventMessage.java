package wechat4j.message.event;

/**
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public class SubscibeEventMessage extends EventMessage {
    public SubscibeEventMessage() {
    }

    public SubscibeEventMessage(String event) {
        super(event);
    }

    public SubscibeEventMessage(String toUserName, String fromUserName, String createTime, String msgType, String messageId, String event) {
        super(toUserName, fromUserName, createTime, msgType, messageId, event);
    }
}

package wechat4j.message.event;

/**
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public class ScanEventMessage extends EventMessage {
    private String eventKey;
    private String ticket;

    public ScanEventMessage(String eventKey, String ticket) {
        this.eventKey = eventKey;
        this.ticket = ticket;
    }

    public ScanEventMessage(String event, String eventKey, String ticket) {
        super(event);
        this.eventKey = eventKey;
        this.ticket = ticket;
    }

    public ScanEventMessage(String toUserName, String fromUserName, String createTime, String msgType, String messageId, String event, String eventKey, String ticket) {
        super(toUserName, fromUserName, createTime, msgType, messageId, event);
        this.eventKey = eventKey;
        this.ticket = ticket;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}

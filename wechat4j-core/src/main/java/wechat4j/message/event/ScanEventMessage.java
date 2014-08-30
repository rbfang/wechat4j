package wechat4j.message.event;

import wechat4j.message.Message;

/**
 * Scan event message
 *
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

    public ScanEventMessage(EventMessage eventMessage, String eventKey, String ticket) {
        super(new Message(eventMessage.getToUserName(), eventMessage.getFromUserName(), eventMessage.getCreateTime(), eventMessage.getMsgType()), eventMessage.getEvent());
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

    @Override
    public String toString() {
        return "ScanEventMessage{" +
                "eventKey='" + eventKey + '\'' +
                ", ticket='" + ticket + '\'' +
                "} " + super.toString();
    }
}

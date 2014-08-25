package wechat4j.message;

import java.io.Serializable;

/**
 * The parent of messages
 *
 * @author renbin.fang.
 * @date 2014/8/21.
 */
public class Message implements Serializable {
    String toUserName;
    String fromUserName;
    String createTime;
    String msgType;
    String messageId;

    /**
     * Constructor
     */
    public Message() {
    }

    /**
     * Use for replying message
     *
     * @param toUserName
     * @param fromUserName
     * @param createTime
     * @param msgType
     */
    public Message(String toUserName, String fromUserName, String createTime, String msgType) {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.msgType = msgType;
    }

    /**
     * Use for receiving message
     *
     * @param toUserName
     * @param fromUserName
     * @param createTime
     * @param msgType
     * @param messageId
     */
    public Message(String toUserName, String fromUserName, String createTime, String msgType, String messageId) {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.msgType = msgType;
        this.messageId = messageId;
    }

    /**
     * ReceivedType
     */
    public enum ReceivedType {
        TEXT("text"),
        IMAGE("image"),
        VOICE("voice"),
        VIDEO("video"),
        LOCATION("location"),
        LINK("link");

        private String value;

        ReceivedType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * SendType
     */
    public enum SendType {
        TEXT("text"),
        IMAGE("image"),
        VOICE("voice"),
        VIDEO("video"),
        MUSIC("music"),
        NEWS("news");

        private String value;

        SendType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
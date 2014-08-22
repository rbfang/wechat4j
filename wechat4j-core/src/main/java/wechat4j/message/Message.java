package wechat4j.message;

import java.io.Serializable;

/**
 * The parent of messages
 *
 * @author renbin.fang.
 * @date 2014/8/21.
 */
public class Message implements Serializable {
    private String toUserName;
    private String fromUserName;
    private String createTime;
    private String msgType;
    private String messageId;

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
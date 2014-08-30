package wechat4j.message;

/**
 * Voice message
 *
 * @author renbin.fang.
 * @date 2014/8/21.
 */
public class VoiceMessage extends Message {
    private String mediaId;

    /**
     * Constructor
     */
    public VoiceMessage() {
    }

    public VoiceMessage(String mediaId, Message message) {
        super.toUserName = message.getToUserName();
        super.fromUserName = message.getFromUserName();
        super.createTime = message.getCreateTime();
        super.msgType = message.getMsgType();
        super.messageId = message.getMessageId();

        this.mediaId = mediaId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public String toString() {
        return "VoiceMessage{" +
                "mediaId='" + mediaId + '\'' +
                "} " + super.toString();
    }
}

package wechat4j.message;

/**
 * Video message
 *
 * @author renbin.fang.
 * @date 2014/8/21.
 */
public class VideoMessage extends Message {
    private String mediaId;
    private String thumbMediaId;

    /**
     * Constructor
     */
    public VideoMessage() {
    }

    /**
     * Constructor
     *
     * @param mediaId
     * @param thumbMediaId
     */
    public VideoMessage(String mediaId, String thumbMediaId, Message message) {
        super.toUserName = message.getToUserName();
        super.fromUserName = message.getFromUserName();
        super.createTime = message.getCreateTime();
        super.msgType = message.getMsgType();
        super.messageId = message.getMessageId();

        this.mediaId = mediaId;
        this.thumbMediaId = thumbMediaId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
}

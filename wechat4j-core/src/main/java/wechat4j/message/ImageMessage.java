package wechat4j.message;

/**
 * Image message
 *
 * @author renbin.fang.
 * @date 2014/8/21.
 */
public class ImageMessage extends Message {
    private String picUrl;
    private String mediaId;

    /**
     * Constructor
     */
    public ImageMessage() {
    }

    /**
     * Constructor
     *
     * @param picUrl
     * @param mediaId
     * @param message
     */
    public ImageMessage(String picUrl, String mediaId, Message message) {
        super.toUserName = message.getToUserName();
        super.fromUserName = message.getFromUserName();
        super.createTime = message.getCreateTime();
        super.msgType = message.getMsgType();
        super.messageId = message.getMessageId();

        this.picUrl = picUrl;
        this.mediaId = mediaId;
    }

    public ImageMessage(String toUserName, String fromUserName, String createTime, String msgType, String messageId, String picUrl, String mediaId) {
        super(toUserName, fromUserName, createTime, msgType, messageId);
        this.picUrl = picUrl;
        this.mediaId = mediaId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}

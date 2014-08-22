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
     */
    public ImageMessage(String picUrl, String mediaId) {
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

package wechat4j.support.bean;

/**
 * Media
 *
 * @author renbin.fang.
 * @date 2014/8/25.
 */
public class Media {
    private String type;
    private String mediaId;
    private String createdAt;

    public Media() {
    }

    public Media(String type, String mediaId, String createdAt) {
        this.type = type;
        this.mediaId = mediaId;
        this.createdAt = createdAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}

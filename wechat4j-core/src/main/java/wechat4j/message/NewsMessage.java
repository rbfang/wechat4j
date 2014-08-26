package wechat4j.message;

import java.io.Serializable;

/**
 * NewsMessage
 *
 * @author renbin.fang.
 * @date 2014/8/26.
 */
public class NewsMessage implements Serializable {
    private String title;
    private String description;
    private String picUrl;
    private String url;

    public NewsMessage() {
    }

    public NewsMessage(String title, String description, String picUrl, String url) {
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

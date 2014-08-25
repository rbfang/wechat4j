package wechat4j.message;

/**
 * Link message
 *
 * @author renbin.fang.
 * @date 2014/8/21.
 */
public class LinkMessage extends Message {
    private String title;
    private String description;
    private String url;

    /**
     * Constructor
     */
    public LinkMessage() {
    }

    /**
     * Constructor
     *
     * @param title
     * @param description
     * @param url
     */
    public LinkMessage(String title, String description, String url, Message message) {
        super.toUserName = message.getToUserName();
        super.fromUserName = message.getFromUserName();
        super.createTime = message.getCreateTime();
        super.msgType = message.getMsgType();
        super.messageId = message.getMessageId();

        this.title = title;
        this.description = description;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
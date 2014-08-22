package wechat4j.message;

/**
 * Text message
 *
 * @author renbin.fang.
 * @date 2014/8/21.
 */
public class TextMessage extends Message {
    private String content;

    /**
     * Constructor
     */
    public TextMessage() {
    }

    /**
     * Constructor
     *
     * @param content
     */
    public TextMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

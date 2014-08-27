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
    public TextMessage(String content, Message message) {
        super.toUserName = message.getToUserName();
        super.fromUserName = message.getFromUserName();
        super.createTime = message.getCreateTime();
        super.msgType = message.getMsgType();
        super.messageId = message.getMessageId();

        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TextMessage{" +
                "content='" + content + '\'' +
                '}';
    }
}

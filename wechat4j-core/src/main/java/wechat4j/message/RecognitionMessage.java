package wechat4j.message;

/**
 * Recognition Message
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public class RecognitionMessage extends Message {
    private String mediaId;
    private String format;
    private String recognition;

    /**
     * Constructor
     */
    public RecognitionMessage() {
    }

    /**
     * Constructor
     *
     * @param mediaId
     * @param format
     * @param recognition
     * @param message
     */
    public RecognitionMessage(String mediaId, String format, String recognition, Message message) {
        super.toUserName = message.getToUserName();
        super.fromUserName = message.getFromUserName();
        super.createTime = message.getCreateTime();
        super.msgType = message.getMsgType();
        super.messageId = message.getMessageId();

        this.mediaId = mediaId;
        this.format = format;
        this.recognition = recognition;
    }

    public enum Format {
        AMR("amr");

        private String value;

        Format(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }

    @Override
    public String toString() {
        return "RecognitionMessage{" +
                "mediaId='" + mediaId + '\'' +
                ", format='" + format + '\'' +
                ", recognition='" + recognition + '\'' +
                "} " + super.toString();
    }
}

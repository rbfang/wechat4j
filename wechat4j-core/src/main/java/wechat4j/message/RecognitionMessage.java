package wechat4j.message;

/**
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public class RecognitionMessage extends Message {
    private String mediaId;
    private String format;
    private String recognition;

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
}

package wechat4j.message;

/**
 * Location message
 *
 * @author renbin.fang.
 * @date 2014/8/21.
 */
public class LocationMessage extends Message {
    private String locationX;
    private String locationY;
    private Integer scale;
    private String label;

    /**
     * Constructor
     */
    public LocationMessage() {
    }

    /**
     * Constructor
     *
     * @param locationX
     * @param locationY
     * @param scale
     * @param label
     */
    public LocationMessage(String locationX, String locationY, Integer scale, String label, Message message) {
        super.toUserName = message.getToUserName();
        super.fromUserName = message.getFromUserName();
        super.createTime = message.getCreateTime();
        super.msgType = message.getMsgType();
        super.messageId = message.getMessageId();

        this.locationX = locationX;
        this.locationY = locationY;
        this.scale = scale;
        this.label = label;
    }

    public String getLocationX() {
        return locationX;
    }

    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    public String getLocationY() {
        return locationY;
    }

    public void setLocationY(String locationY) {
        this.locationY = locationY;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

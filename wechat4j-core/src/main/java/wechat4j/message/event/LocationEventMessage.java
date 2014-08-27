package wechat4j.message.event;

/**
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public class LocationEventMessage extends EventMessage {
    private Double latitude;
    private Double longitude;
    private Double precision;

    public LocationEventMessage(Double latitude, Double longitude, Double precision) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.precision = precision;
    }

    public LocationEventMessage(String event, Double latitude, Double longitude, Double precision) {
        super(event);
        this.latitude = latitude;
        this.longitude = longitude;
        this.precision = precision;
    }

    public LocationEventMessage(String toUserName, String fromUserName, String createTime, String msgType, String messageId, String event, Double latitude, Double longitude, Double precision) {
        super(toUserName, fromUserName, createTime, msgType, messageId, event);
        this.latitude = latitude;
        this.longitude = longitude;
        this.precision = precision;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getPrecision() {
        return precision;
    }

    public void setPrecision(Double precision) {
        this.precision = precision;
    }
}

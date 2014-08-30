package wechat4j.message.event;

import wechat4j.message.Message;

/**
 * Location event message
 *
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

    public LocationEventMessage(EventMessage eventMessage, Double latitude, Double longitude, Double precision) {
        super(new Message(eventMessage.getToUserName(), eventMessage.getFromUserName(), eventMessage.getCreateTime(), eventMessage.getMsgType()), eventMessage.getEvent());

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

    @Override
    public String toString() {
        return "LocationEventMessage{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", precision=" + precision +
                "} " + super.toString();
    }
}

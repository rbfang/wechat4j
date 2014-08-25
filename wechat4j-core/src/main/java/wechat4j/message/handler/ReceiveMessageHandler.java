package wechat4j.message.handler;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import wechat4j.message.*;

import java.io.InputStream;

/**
 * Receive message handler
 *
 * @author renbin.fang.
 * @date 2014/8/21.
 */
public class ReceiveMessageHandler implements IReceiveMessageHandler {
    private static XMLConfiguration xmlReader = null;

    static {
        xmlReader = new XMLConfiguration();
    }

    /**
     * Reloads input stream
     *
     * @param inputStream
     * @throws ConfigurationException
     */
    private void reloadInputStream(InputStream inputStream) {
        xmlReader.clear();
        try {
            xmlReader.load(inputStream);
        } catch (ConfigurationException e) {
            System.out.println(e);
        }
    }

    @Override
    public TextMessage getTextMessage(InputStream inputStream) {
        reloadInputStream(inputStream);

        return new TextMessage(
                xmlReader.getString("Content"),
                getMessage());
    }

    @Override
    public ImageMessage getImageMessage(InputStream inputStream) {
        reloadInputStream(inputStream);

        return new ImageMessage(
                xmlReader.getString("PicUrl"),
                xmlReader.getString("MediaId"),
                getMessage());
    }

    @Override
    public VoiceMessage getVoiceMessage(InputStream inputStream) {
        reloadInputStream(inputStream);

        return new VoiceMessage(
                xmlReader.getString("MediaId"),
                getMessage());
    }

    @Override
    public VideoMessage getVideoMessage(InputStream inputStream) {
        reloadInputStream(inputStream);

        return new VideoMessage(
                xmlReader.getString("MediaId"),
                xmlReader.getString("ThumbMediaId"),
                getMessage());
    }

    @Override
    public LocationMessage getMusicMessage(InputStream inputStream) {
        reloadInputStream(inputStream);

        return new LocationMessage(
                xmlReader.getString("LocationX"),
                xmlReader.getString("LocationY"),
                Integer.valueOf(xmlReader.getString("Scale")),
                xmlReader.getString("Label"),
                getMessage());
    }

    @Override
    public LinkMessage getNewsMessage(InputStream inputStream) {
        reloadInputStream(inputStream);

        return new LinkMessage(
                xmlReader.getString("Title"),
                xmlReader.getString("Description"),
                xmlReader.getString("Url"),
                getMessage());
    }

    /**
     * Put message header into the base class.
     *
     * @return {@link wechat4j.message.Message}
     */
    private Message getMessage() {
        return new Message(
                xmlReader.getString("ToUserName"),
                xmlReader.getString("FromUserName"),
                xmlReader.getString("CreateTime"),
                xmlReader.getString("MsgType"),
                xmlReader.getString("MsgId"));
    }
}

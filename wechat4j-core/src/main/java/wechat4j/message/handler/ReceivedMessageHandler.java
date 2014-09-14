package wechat4j.message.handler;

import org.apache.commons.configuration.XMLConfiguration;
import wechat4j.message.*;

import java.io.InputStream;

/**
 * Receive message handler
 *
 * @author renbin.fang.
 * @date 2014/8/21.
 */
public class ReceivedMessageHandler extends AbstractReceiveMessageHandler {
    private static XMLConfiguration xmlReader;

    @Override
    public XMLConfiguration getXmlReader() {
        if (xmlReader == null) {
            xmlReader = new XMLConfiguration();
        }

        return xmlReader;
    }

    @Override
    protected String getClassName() {
        return getClass().getName();
    }

    private TextMessage getTextMessage(Message message) {
        return new TextMessage(
                xmlReader.getString("Content"),
                message);
    }

    private ImageMessage getImageMessage(Message message) {
        return new ImageMessage(
                xmlReader.getString("PicUrl"),
                xmlReader.getString("MediaId"),
                message);
    }

    private VoiceMessage getVoiceMessage(Message message) {
        //TODO 添加语音识别结果
        return new VoiceMessage(
                xmlReader.getString("MediaId"),
                message);
    }

    private VideoMessage getVideoMessage(Message message) {
        return new VideoMessage(
                xmlReader.getString("MediaId"),
                xmlReader.getString("ThumbMediaId"),
                message);
    }

    private LocationMessage getLocationMessage(Message message) {
        return new LocationMessage(
                xmlReader.getString("LocationX"),
                xmlReader.getString("LocationY"),
                Integer.valueOf(xmlReader.getString("Scale")),
                xmlReader.getString("Label"),
                message);
    }

    private LinkMessage getLinkMessage(Message message) {
        return new LinkMessage(
                xmlReader.getString("Title"),
                xmlReader.getString("Description"),
                xmlReader.getString("Url"),
                message);
    }

    @Override
    public Message getMessage(InputStream inputStream) {
        return getMessageFromInputStream(inputStream);
    }
}
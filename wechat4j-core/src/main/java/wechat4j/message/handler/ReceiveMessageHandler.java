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
public class ReceiveMessageHandler extends AbstractReceiveMessageHandler {
    private static XMLConfiguration xmlReader;

    private Class<? extends MessageHandler> clz;

    @Override
    public XMLConfiguration getXmlReader() {
        if (xmlReader == null) {
            xmlReader = new XMLConfiguration();
        }

        return xmlReader;
    }


    @Override
    public Message getMessage(InputStream inputStream) {
        reloadInputStream(inputStream);

        Message message = getMessageHeader();
        message = getMessageFromXml(message.getMsgType(), inputStream);

        return message;
    }

    public TextMessage getTextMessage(InputStream inputStream) {
        return new TextMessage(
                xmlReader.getString("Content"),
                getMessageHeader());
    }

    protected ImageMessage getImageMessage(InputStream inputStream) {
        return new ImageMessage(
                xmlReader.getString("PicUrl"),
                xmlReader.getString("MediaId"),
                getMessageHeader());
    }

    protected VoiceMessage getVoiceMessage(InputStream inputStream) {
        return new VoiceMessage(
                xmlReader.getString("MediaId"),
                getMessageHeader());
    }

    private VideoMessage getVideoMessage(InputStream inputStream) {
        return new VideoMessage(
                xmlReader.getString("MediaId"),
                xmlReader.getString("ThumbMediaId"),
                getMessageHeader());
    }

    private LocationMessage getLocationMessage(InputStream inputStream) {
        return new LocationMessage(
                xmlReader.getString("LocationX"),
                xmlReader.getString("LocationY"),
                Integer.valueOf(xmlReader.getString("Scale")),
                xmlReader.getString("Label"),
                getMessageHeader());
    }

    private LinkMessage getLinkMessage(InputStream inputStream) {
        return new LinkMessage(
                xmlReader.getString("Title"),
                xmlReader.getString("Description"),
                xmlReader.getString("Url"),
                getMessageHeader());
    }
}

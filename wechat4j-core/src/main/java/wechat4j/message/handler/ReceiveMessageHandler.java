package wechat4j.message.handler;

import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.lang.StringUtils;
import wechat4j.message.*;

import java.io.InputStream;

import static wechat4j.message.Message.ReceivedType;

/**
 * Receive message handler
 *
 * @author renbin.fang.
 * @date 2014/8/21.
 */
public class ReceiveMessageHandler extends AbstractReceiveMessageHandler {
    private static XMLConfiguration xmlReader;

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
        String msgType = message.getMsgType();

        if (StringUtils.equals(msgType, ReceivedType.TEXT.getValue())) {

            return getTextMessage(inputStream);

        } else if (StringUtils.equals(msgType, ReceivedType.IMAGE.getValue())) {

            return getImageMessage(inputStream);

        } else if (StringUtils.equals(msgType, ReceivedType.VOICE.getValue())) {

            return getVoiceMessage(inputStream);

        } else if (StringUtils.equals(msgType, ReceivedType.VIDEO.getValue())) {

            return getVideoMessage(inputStream);

        } else if (StringUtils.equals(msgType, ReceivedType.LOCATION.getValue())) {

            return getLocationMessage(inputStream);

        } else if (StringUtils.equals(msgType, ReceivedType.LINK.getValue())) {

            return getLinkMessage(inputStream);

        }

        return message;
    }


    private TextMessage getTextMessage(InputStream inputStream) {
        return new TextMessage(
                xmlReader.getString("Content"),
                getMessageHeader());
    }

    private ImageMessage getImageMessage(InputStream inputStream) {
        return new ImageMessage(
                xmlReader.getString("PicUrl"),
                xmlReader.getString("MediaId"),
                getMessageHeader());
    }

    private VoiceMessage getVoiceMessage(InputStream inputStream) {
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

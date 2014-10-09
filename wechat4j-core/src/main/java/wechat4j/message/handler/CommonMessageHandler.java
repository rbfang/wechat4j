package wechat4j.message.handler;

import org.apache.commons.configuration.XMLConfiguration;
import wechat4j.message.*;

import java.io.InputStream;

/**
 * 普通消息处理
 *
 * @author renbin.fang.
 * @date 2014/8/21.
 */
public class CommonMessageHandler extends AbstractReceivingMessageHandler {
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


    @Override
    public Message getMessage(InputStream inputStream) {
        return getMessageFromInputStream(inputStream);
    }

    /**
     * 文本消息
     *
     * @param message
     * @return
     */
    private TextMessage getTextMessage(Message message) {
        return new TextMessage(
                xmlReader.getString("Content"),
                message);
    }

    /**
     * 图片消息
     *
     * @param message
     * @return
     */
    private ImageMessage getImageMessage(Message message) {
        return new ImageMessage(
                xmlReader.getString("PicUrl"),
                xmlReader.getString("MediaId"),
                message);
    }

    /**
     * 音频消息
     *
     * @param message
     * @return
     */
    private VoiceMessage getVoiceMessage(Message message) {
        //TODO 添加语音识别结果
        return new VoiceMessage(
                xmlReader.getString("MediaId"),
                message);
    }

    /**
     * 视频消息
     *
     * @param message
     * @return
     */
    private VideoMessage getVideoMessage(Message message) {
        return new VideoMessage(
                xmlReader.getString("MediaId"),
                xmlReader.getString("ThumbMediaId"),
                message);
    }

    /**
     * 地理位置消息
     *
     * @param message
     * @return
     */
    private LocationMessage getLocationMessage(Message message) {
        return new LocationMessage(
                xmlReader.getString("LocationX"),
                xmlReader.getString("LocationY"),
                Integer.valueOf(xmlReader.getString("Scale")),
                xmlReader.getString("Label"),
                message);
    }

    /**
     * 链接消息
     *
     * @param message
     * @return
     */
    private LinkMessage getLinkMessage(Message message) {
        return new LinkMessage(
                xmlReader.getString("Title"),
                xmlReader.getString("Description"),
                xmlReader.getString("Url"),
                message);
    }
}
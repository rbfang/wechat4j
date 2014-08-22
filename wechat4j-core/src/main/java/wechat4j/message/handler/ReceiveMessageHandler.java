package wechat4j.message.handler;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import wechat4j.message.*;

import java.io.InputStream;

/**
 * Receive message operator
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
    void reloadInputStream(InputStream inputStream) {
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

        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(xmlReader.getString("ToUserName"));
        textMessage.setFromUserName(xmlReader.getString("FromUserName"));
        textMessage.setCreateTime(xmlReader.getString("CreateTime"));
        textMessage.setMsgType(xmlReader.getString("MsgType"));
        textMessage.setContent(xmlReader.getString("Content"));
        textMessage.setMessageId(xmlReader.getString("MsgId"));

        return textMessage;
    }

    @Override
    public ImageMessage getImageMessage(InputStream inputStream) {
        reloadInputStream(inputStream);

        return null;
    }

    @Override
    public VoiceMessage getVoiceMessage(InputStream inputStream) {
        reloadInputStream(inputStream);

        return null;
    }

    @Override
    public VideoMessage getVideoMessage(InputStream inputStream) {
        reloadInputStream(inputStream);

        return null;
    }

    @Override
    public LocationMessage getMusicMessage(InputStream inputStream) {
        reloadInputStream(inputStream);

        return null;
    }

    @Override
    public LinkMessage getNewsMessage(InputStream inputStream) {
        reloadInputStream(inputStream);

        return null;
    }
}

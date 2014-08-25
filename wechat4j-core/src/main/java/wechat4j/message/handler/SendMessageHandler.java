package wechat4j.message.handler;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import wechat4j.message.Message;
import wechat4j.message.TextMessage;

import java.util.Date;

/**
 * SendMessageHandler
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public class SendMessageHandler implements ISendMessageHandler {
    private static final String TEMPLATE_PATH = "/wechat-template.xml";
    private static XMLConfiguration replyTemplate;

    private final static String MSG_START = "<![CDATA[";
    private final static String MSG_END = "]]>";

    static {
        try {
            replyTemplate = new XMLConfiguration(TEMPLATE_PATH);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Generate message header
     *
     * @param message
     * @return
     */
    private String generateHeader(Message message) {
        return replyTemplate.getString("MessageHeader")
                .replace("${ToUserName}", addLabel(message.getToUserName()))
                .replace("${FromUserName}", addLabel(message.getFromUserName()))
                .replace("${CreateTime}", addLabel(message.getCreateTime()))
                .replace("${MsgType}", addLabel(message.getMsgType()));
    }

    private String addLabel(String content) {
        return MSG_START + content + MSG_END;
    }

    @Override
    public String generateTextMessage(String content, Message message) {
        return replyTemplate.getString("TextMessage")
                .replace("${MessageHeader}", generateHeader(message))
                .replace("${Content}", content);
    }

    @Override
    public String generateImageMessage(String mediaId, Message message) {

        return null;
    }

    @Override
    public String generateVoiceMessage() {
        return null;
    }

    @Override
    public String generateVideoMessage() {
        return null;
    }

    @Override
    public String generateMusicMessage() {
        return null;
    }

    @Override
    public String generateNewsMessage() {
        return null;
    }
}

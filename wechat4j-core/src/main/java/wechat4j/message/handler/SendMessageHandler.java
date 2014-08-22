package wechat4j.message.handler;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

/**
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public class SendMessageHandler implements ISendMessageHandler {
    private static final String TEMPLATE_PATH = "/wechat-template.xml";
    private static XMLConfiguration replyTemplate;

    static {
        try {
            replyTemplate = new XMLConfiguration(TEMPLATE_PATH);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String generateTextMessage(String content) {
        return replyTemplate.getString("TextMessage");
    }

    @Override
    public String generateImageMessage() {
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

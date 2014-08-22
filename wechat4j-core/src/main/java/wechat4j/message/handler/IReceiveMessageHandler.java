package wechat4j.message.handler;

import org.apache.commons.configuration.ConfigurationException;
import wechat4j.message.*;

import java.io.InputStream;

/**
 * IReceiveMessageOperator
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public interface IReceiveMessageHandler extends MessageHandler {

    TextMessage getTextMessage(InputStream inputStream) throws ConfigurationException;

    ImageMessage getImageMessage(InputStream inputStream);

    VoiceMessage getVoiceMessage(InputStream inputStream);

    VideoMessage getVideoMessage(InputStream inputStream);

    LocationMessage getMusicMessage(InputStream inputStream);

    LinkMessage getNewsMessage(InputStream inputStream);
}

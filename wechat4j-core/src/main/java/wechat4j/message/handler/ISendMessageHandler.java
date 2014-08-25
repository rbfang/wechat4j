package wechat4j.message.handler;

import wechat4j.message.Message;

/**
 * ISendMessageOperator
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public interface ISendMessageHandler extends MessageHandler {
    String generateTextMessage(String content, Message message);

    String generateImageMessage(String mediaId, Message message);

    String generateVoiceMessage();

    String generateVideoMessage();

    String generateMusicMessage();

    String generateNewsMessage();
}

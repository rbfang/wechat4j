package wechat4j.message.handler;

/**
 * ISendMessageOperator
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public interface ISendMessageHandler extends MessageHandler {
    String generateTextMessage(String content);

    String generateImageMessage();

    String generateVoiceMessage();

    String generateVideoMessage();

    String generateMusicMessage();

    String generateNewsMessage();
}

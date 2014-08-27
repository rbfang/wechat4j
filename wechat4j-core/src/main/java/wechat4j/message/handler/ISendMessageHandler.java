package wechat4j.message.handler;

import wechat4j.message.Message;
import wechat4j.message.NewsMessage;

import java.util.List;

/**
 * ISendMessageOperator
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public interface ISendMessageHandler {
    String generateTextMessage(String content, Message message);

    String generateImageMessage(String mediaId, Message message);

    String generateVoiceMessage(String mediaId, Message message);

    String generateVideoMessage(String mediaId, String title, String description, Message message);

    String generateMusicMessage(String title, String description, String musicUrl, String hQMusicUrl, String thumbMediaId, Message message);

    String generateNewsMessage(List<NewsMessage> newsMessageList, Message message);
}

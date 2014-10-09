package wechat4j.message.handler;

import wechat4j.message.Message;
import wechat4j.message.NewsMessage;

import java.util.List;

/**
 * 生成被动响应消息接口
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public interface ISendMessageHandler {
    /**
     * 生成文本消息
     *
     * @param content 消息内容
     * @param message 消息信息 ​
     * @return xml格式的回复信息              ​
     */
    String generateTextMessage(String content, Message message);

    /**
     * 生成图片消息
     *
     * @param mediaId 通过上传多媒体文件，得到的id
     * @param message 消息信息                                 ​
     * @return xml格式的图片回复信息              ​
     */
    String generateImageMessage(String mediaId, Message message);

    /**
     * 生成音频消息
     *
     * @param mediaId 通过上传多媒体文件，得到的id
     * @param message 消息信息                                 ​
     * @return xml格式的音频消息
     */
    String generateVoiceMessage(String mediaId, Message message);


    /**
     * 生成视频格式消息
     *
     * @param mediaId     通过上传多媒体文件，得到的id
     * @param title       标题   ​
     * @param description 描述
     * @param message     消息信息        ​
     * @return xml格式的视频消息       ​
     */
    String generateVideoMessage(String mediaId, String title, String description, Message message);

    /**
     * 生成音乐格式消息
     *
     * @param title        标题   ​
     * @param description  描述 ​
     * @param musicUrl     音乐url
     * @param hQMusicUrl   高质量音乐链接，WIFI环境优先使用该链接播放音乐
     * @param thumbMediaId 缩略图的媒体id，通过上传多媒体文件，得到的id
     * @param message      消息信息 ​
     * @return xml       ​格式的音乐消息
     */
    String generateMusicMessage(String title, String description, String musicUrl, String hQMusicUrl, String thumbMediaId, Message message);

    /**
     * 生成新闻消息
     *
     * @param newsMessageList 新闻信息列表
     * @param message         消息信息 ​
     * @return xml格式的新闻消息
     */
    String generateNewsMessage(List<NewsMessage> newsMessageList, Message message);
}

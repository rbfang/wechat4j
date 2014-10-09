package wechat4j.message.handler;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import wechat4j.message.Message;
import wechat4j.message.NewsMessage;

import java.io.File;
import java.util.List;

/**
 * 生成被动响应消息实现类
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public class SendMessageHandler implements ISendMessageHandler {
    private static final String TEMPLATE_PATH = "/wechat-template.xml";
    private static XMLConfiguration replyTemplate;

    private final static String MSG_START = "<![CDATA[";
    private final static String MSG_END = "]]>";

    {
        // 载入回复消息模板
        try {
            replyTemplate = new XMLConfiguration(getClass().getResource(TEMPLATE_PATH).getFile());
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
    private String generateTemplate(String path, Message message) {
        return replyTemplate.getString(path)
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
        return generateTemplate("TextMessage", message).replace("${Content}", content);
    }

    @Override
    public String generateImageMessage(String mediaId, Message message) {
        String imageMessageTemplate = generateTemplate("ImageMessage.Common", message);
        String image = replyTemplate.getString("ImageMessage.Image").replace("${MediaId}", mediaId);

        return imageMessageTemplate.replace("${Image}", image);
    }

    @Override
    public String generateVoiceMessage(String mediaId, Message message) {
        return generateTemplate("VoiceMessage.Common", message)
                .replace("${Voice}", replyTemplate.getString("VoiceMessage.Voice")
                        .replace("${MediaId}", mediaId));
    }

    @Override
    public String generateVideoMessage(String mediaId, String title, String description, Message message) {
        return generateTemplate("VideoMessage.Common", message).replace("${Video}", replyTemplate.getString("VideoMessage.Video")
                        .replace("${MediaId}", mediaId)
                        .replace("${Title}", title)
                        .replace("${Description}", description)
        );
    }

    @Override
    public String generateMusicMessage(String title, String description, String musicUrl, String hQMusicUrl, String thumbMediaId, Message message) {
        return generateTemplate("MusicMessage.Common", message).replace("${Music}", replyTemplate.getString("MusicMessage.Music")
                .replace("${Title}", title)
                .replace("${Description}", description)
                .replace("${MusicUrl}", musicUrl)
                .replace("${HQMusicUrl}", hQMusicUrl)
                .replace("${ThumbMediaId}", thumbMediaId));
    }

    @Override
    public String generateNewsMessage(List<NewsMessage> newsMessageList, Message message) {

        return generateTemplate("NewsMessage.Common", message)
                .replace("${ArticleCount}", String.valueOf(newsMessageList.size()))
                .replace("${Article}", generateArticles(newsMessageList));
    }

    /**
     * 生成文章xml格式，可以有一篇或多篇
     *
     * @param newsMessageList 新闻列表      ​
     * @return xml格式的新闻列表
     */
    private String generateArticles(List<NewsMessage> newsMessageList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (NewsMessage newsMessage : newsMessageList) {
            String articleTemplate = replyTemplate.getString("NewsMessage.Article");
            stringBuilder.append(articleTemplate
                            .replace("${Title}", newsMessage.getTitle())
                            .replace("${Description}", newsMessage.getDescription())
                            .replace("${Picurl}", newsMessage.getPicUrl())
                            .replace("${Url}", newsMessage.getUrl())
            );
        }

        return stringBuilder.toString();
    }
}

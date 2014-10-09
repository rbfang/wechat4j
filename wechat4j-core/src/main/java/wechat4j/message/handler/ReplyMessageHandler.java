package wechat4j.message.handler;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import wechat4j.message.Message;
import wechat4j.message.NewsMessage;

import java.io.File;
import java.util.List;

/**
 * <p>发送消息：被动响应消息生成器</p>
 * <p>使用XML模板来进行替换占位符生成符合微信服务器收取信息的格式</p>
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 * @see /http://mp.weixin.qq.com/wiki/index.php?title=%E5%8F%91%E9%80%81%E8%A2%AB%E5%8A%A8%E5%93%8D%E5%BA%94%E6%B6%88%E6%81%AF
 */
public class ReplyMessageHandler implements IReplyMessageHandler {
    private static final String TEMPLATE_PATH = "/wechat-template.xml";
    private static XMLConfiguration replyTemplate;

    private final static String MSG_START = "<![CDATA[";
    private final static String MSG_END = "]]>";

    {
        // 载入模板
        try {
            replyTemplate = new XMLConfiguration(getClass().getResource(TEMPLATE_PATH).getFile());
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>生成回复消息的头部，所有回复信息共有的信息<p/>
     * <p>包括：ToUserName, FromUserName, CreateTime, MsgType </p>
     *
     * @param xmlPath
     * @param message
     * @return
     */
    private String generateTemplate(String xmlPath, Message message) {
        return replyTemplate.getString(xmlPath)
                .replace("${ToUserName}", addLabel(message.getToUserName()))
                .replace("${FromUserName}", addLabel(message.getFromUserName()))
                .replace("${CreateTime}", addLabel(message.getCreateTime()))
                .replace("${MsgType}", addLabel(message.getMsgType()));
    }

    /**
     * 将内容放到CDATA 区段
     */
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

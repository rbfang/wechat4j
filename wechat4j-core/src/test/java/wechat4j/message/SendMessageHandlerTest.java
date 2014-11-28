package wechat4j.message;

import org.testng.annotations.Test;
import wechat4j.message.handler.IReplyMessageHandler;
import wechat4j.message.handler.ReplyMessageHandler;

import java.util.Arrays;
import java.util.List;

/**
 * SendMessageHandlerTest
 *
 * @author renbin.fang.
 * @date 2014/8/25.
 */
public class SendMessageHandlerTest {
    private Message message = new Message("toUserName", "fromUserName", "123123123", "text");

    private static IReplyMessageHandler replyMessageHandler = new ReplyMessageHandler();

    @Test
    public void generateTextMessage() {
        System.out.println(replyMessageHandler.generateTextMessage(
                "Hello,", message));
    }

    @Test
    public void generateImageMessage() {
        message.setMsgType(Message.SendType.IMAGE.getValue());
        System.out.println(replyMessageHandler.generateImageMessage(
                "wxd30e31bfd8c207ee", message));
    }

    @Test
    public void generateVoiceMessage() {
        message.setMsgType(Message.SendType.VOICE.getValue());
        System.out.println(replyMessageHandler.generateVoiceMessage(
                "wxd30e31bfd8c207ee", message));
    }

    @Test
    public void generateVideoMessage() {
        message.setMsgType(Message.SendType.VIDEO.getValue());

        String mediaId = "wxd30e31bfd8c207ee",
                title = "title of video",
                description = "this is a video.";

        System.out.println(replyMessageHandler.generateVideoMessage(
                mediaId,
                title,
                description,
                message));
    }

    @Test
    public void generateMusicMessage() {
        message.setMsgType(Message.SendType.MUSIC.getValue());

        String title = "the sound of silence",
                description = "My favourite song",
                musicUrl = "http://music.com/the_sound_of_slience.mp3",
                hQMusicUrl = "http://music.com/the_sound_of_slience_hq.mp3",
                thumbMediaId = "wxd30e31bfd8c207ee";

        System.out.println(replyMessageHandler.generateMusicMessage(
                title,
                description,
                musicUrl,
                hQMusicUrl,
                thumbMediaId,
                message));
    }

    @Test
    public void generateNewsMessage() {
        message.setMsgType(Message.SendType.NEWS.getValue());

        List<NewsMessage> newsMessageList = Arrays.asList(
                new NewsMessage("title1", "description", "picUrl", "newsUrl"),
                new NewsMessage("title2", "description", "picUrl", "newsUrl"),
                new NewsMessage("title3", "description", "picUrl", "newsUrl"),
                new NewsMessage("title4", "description", "picUrl", "newsUrl"));


        System.out.println(replyMessageHandler.generateNewsMessage(
                newsMessageList,
                message));

    }
}
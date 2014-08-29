//package wechat4j.message;
//
//import org.junit.Test;
//import wechat4j.message.handler.ISendMessageHandler;
//import wechat4j.message.handler.MessageOperatorFactory;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * SendMessageHandlerTest
// *
// * @author renbin.fang.
// * @date 2014/8/25.
// */
//public class SendMessageHandlerTest {
//    private Message message = new Message("toUserName", "fromUserName", "123123123", "text");
//
//    @Test
//    public void generateTextMessage() {
//        ISendMessageHandler sendMessageHandler = MessageOperatorFactory.getSendMessageOperator();
//        System.out.println(sendMessageHandler.generateTextMessage(
//                "Hello,", message));
//    }
//
//    @Test
//    public void generateImageMessage() {
//        ISendMessageHandler sendMessageHandler = MessageOperatorFactory.getSendMessageOperator();
//
//        message.setMsgType(Message.SendType.IMAGE.getValue());
//        System.out.println(sendMessageHandler.generateImageMessage(
//                "wxd30e31bfd8c207ee", message));
//    }
//
//    @Test
//    public void generateVoiceMessage() {
//        ISendMessageHandler sendMessageHandler = MessageOperatorFactory.getSendMessageOperator();
//
//        message.setMsgType(Message.SendType.VOICE.getValue());
//        System.out.println(sendMessageHandler.generateVoiceMessage(
//                "wxd30e31bfd8c207ee", message));
//    }
//
//    @Test
//    public void generateVideoMessage() {
//        ISendMessageHandler sendMessageHandler = MessageOperatorFactory.getSendMessageOperator();
//
//        message.setMsgType(Message.SendType.VIDEO.getValue());
//
//        String mediaId = "wxd30e31bfd8c207ee",
//                title = "title of video",
//                description = "this is a video.";
//
//        System.out.println(sendMessageHandler.generateVideoMessage(
//                mediaId,
//                title,
//                description,
//                message));
//    }
//
//    @Test
//    public void generateMusicMessage() {
//        ISendMessageHandler sendMessageHandler = MessageOperatorFactory.getSendMessageOperator();
//
//        message.setMsgType(Message.SendType.MUSIC.getValue());
//
//        String title = "the sound of silence",
//                description = "My favourite song",
//                musicUrl = "http://music.com/the_sound_of_slience.mp3",
//                hQMusicUrl = "http://music.com/the_sound_of_slience_hq.mp3",
//                thumbMediaId = "wxd30e31bfd8c207ee";
//
//        System.out.println(sendMessageHandler.generateMusicMessage(
//                title,
//                description,
//                musicUrl,
//                hQMusicUrl,
//                thumbMediaId,
//                message));
//    }
//
//    @Test
//    public void generateNewsMessage() {
//        ISendMessageHandler sendMessageHandler = MessageOperatorFactory.getSendMessageOperator();
//
//        message.setMsgType(Message.SendType.NEWS.getValue());
//
//        List<NewsMessage> newsMessageList = new ArrayList<NewsMessage>();
//        newsMessageList.add(new NewsMessage("title1", "description", "picUrl", "newsUrl"));
//        newsMessageList.add(new NewsMessage("title2", "description", "picUrl", "newsUrl"));
//        newsMessageList.add(new NewsMessage("title3", "description", "picUrl", "newsUrl"));
//        newsMessageList.add(new NewsMessage("title4", "description", "picUrl", "newsUrl"));
//
//        System.out.println(sendMessageHandler.generateNewsMessage(
//                newsMessageList,
//                message));
//
//    }
//}
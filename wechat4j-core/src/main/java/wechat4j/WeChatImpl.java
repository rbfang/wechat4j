//package wechat4j;
//
//import org.apache.commons.configuration.ConfigurationException;
//import org.apache.commons.configuration.XMLConfiguration;
//import org.apache.commons.lang.StringUtils;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import wechat4j.message.Message;
//import wechat4j.message.NewsMessage;
//import wechat4j.support.bean.AccessToken;
//import wechat4j.bean.user.FollowerList;
//import wechat4j.bean.user.UserInfo;
//import wechat4j.bean.user.Group;
//
//import java.io.InputStream;
//import java.util.List;
//
///**
// * @author renbin.fang.
// * @date 2014/9/5.
// */
//public class WeChatImpl extends AbstractWechat {
//    private final Log logger = LogFactory.getLog(getClass());
//
//    @Override
//    public AccessToken getAccessToken() {
//        return accessTokenGetter.getAccessToken();
//    }
//
//    @Override
//    public AccessToken getAccessToken(String appId, String appSecret) {
//        return accessTokenGetter.getAccessToken(appId, appSecret);
//    }
//
//    @Override
//    public boolean createMenu(String jsonData) {
//        return menuHandler.createMenu(jsonData);
//    }
//
//    @Override
//    public String queryMenu() {
//        return menuHandler.queryMenu();
//    }
//
//    @Override
//    public boolean deleteMenu() {
//        return menuHandler.deleteMenu();
//    }
//
//    @Override
//    public String generateTextMessage(String content, Message message) {
//        return sendMessageHandler.generateTextMessage(content, message);
//    }
//
//    @Override
//    public String generateImageMessage(String mediaId, Message message) {
//        return sendMessageHandler.generateImageMessage(mediaId, message);
//    }
//
//    @Override
//    public String generateVoiceMessage(String mediaId, Message message) {
//        return sendMessageHandler.generateVoiceMessage(mediaId, message);
//    }
//
//    @Override
//    public String generateVideoMessage(String mediaId, String title, String description, Message message) {
//        return sendMessageHandler.generateVideoMessage(mediaId, title, description, message);
//    }
//
//    @Override
//    public String generateMusicMessage(String title, String description, String musicUrl, String hQMusicUrl, String thumbMediaId, Message message) {
//        return sendMessageHandler.generateMusicMessage(title, description, musicUrl, hQMusicUrl, thumbMediaId, message);
//    }
//
//    @Override
//    public String generateNewsMessage(List<NewsMessage> newsMessageList, Message message) {
//        return sendMessageHandler.generateNewsMessage(newsMessageList, message);
//    }
//
//    @Override
//    public boolean createGroup(String groupName) {
//        return userGroupOperator.createGroup(groupName);
//    }
//
//    @Override
//    public List<Group> findAllGroup() {
//        return userGroupOperator.findAllGroup();
//    }
//
//    @Override
//    public int findGroup(String openId) {
//        return userGroupOperator.findGroup(openId);
//    }
//
//    @Override
//    public boolean updateGroupName(Long groupId, String groupName) {
//        return userGroupOperator.updateGroupName(groupId, groupName);
//    }
//
//    @Override
//    public boolean moveToAnotherGroup(String openId, Integer groupId) {
//        return userGroupOperator.moveToAnotherGroup(openId, groupId);
//    }
//
//    @Override
//    public boolean remarkUserName(String openId, String givenName) {
//        return userOperator.remarkUserName(openId, givenName);
//    }
//
//    @Override
//    public UserInfo getUserInfo(String openId) {
//        return userOperator.getUserInfo(openId);
//    }
//
//    @Override
//    public FollowerList getFollowerList(String nextOpenId) {
//        return userOperator.getFollowerList(nextOpenId);
//    }
//
//    @Override
//    public Message getMessage(InputStream inputStream) {
//        XMLConfiguration xmlConfiguration = new XMLConfiguration();
//
//        Message message = null;
//        try {
//            xmlConfiguration.load(inputStream);
//            String msgType = xmlConfiguration.getString("MsgType");
//            if (StringUtils.equals(msgType, Message.ReceivedType.EVENT.toString())) {
//                message = recivedEventHandler.getMessage(inputStream);
//            } else {
//                message = recivedMessageHandler.getMessage(inputStream);
//            }
//
//        } catch (ConfigurationException e) {
//            e.printStackTrace();
//            logger.error(e.toString());
//        }
//
//        return message;
//    }
//}

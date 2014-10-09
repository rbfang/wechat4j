package wechat4j;

import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import wechat4j.bean.user.FollowerList;
import wechat4j.bean.user.Group;
import wechat4j.bean.user.UserInfo;
import wechat4j.message.Message;
import wechat4j.message.NewsMessage;

import java.io.InputStream;
import java.util.List;

/**
 * WeChatImpl
 *
 * @author renbin.fang.
 * @date 2014/9/5.
 */
public class WeChatImpl extends AbstractWechat {
    private final Log logger = LogFactory.getLog(getClass());
    private static XMLConfiguration xmlConfiguration = new XMLConfiguration();

    @Override
    public Message getMessage(InputStream inputStream) {
        Message message = null;
        try {
            xmlConfiguration.load(inputStream);
            String msgType = xmlConfiguration.getString("MsgType");
            if (StringUtils.equals(msgType, Message.ReceivedType.EVENT.toString())) {
                message = eventMessageHandler.getMessage(inputStream);
            } else {
                message = commonMessageHandler.getMessage(inputStream);
            }
        } catch (org.apache.commons.configuration.ConfigurationException e) {
            e.printStackTrace();
        }

        return message;
    }

    @Override
    public boolean createMenu(String jsonData) {
        return menuHandler.createMenu(jsonData);
    }

    @Override
    public String queryMenu() {
        return menuHandler.queryMenu();
    }

    @Override
    public boolean deleteMenu() {
        return menuHandler.deleteMenu();
    }

    @Override
    public String generateTextMessage(String content, Message message) {
        return sendMessageHandler.generateTextMessage(content, message);
    }

    @Override
    public String generateImageMessage(String mediaId, Message message) {
        return sendMessageHandler.generateImageMessage(mediaId, message);
    }

    @Override
    public String generateVoiceMessage(String mediaId, Message message) {
        return sendMessageHandler.generateVoiceMessage(mediaId, message);
    }

    @Override
    public String generateVideoMessage(String mediaId,
                                       String title,
                                       String description,
                                       Message message) {

        return sendMessageHandler.generateVideoMessage(mediaId, title, description, message);
    }

    @Override
    public String generateMusicMessage(String title,
                                       String description,
                                       String musicUrl,
                                       String hQMusicUrl,
                                       String thumbMediaId,
                                       Message message) {

        return sendMessageHandler.generateMusicMessage(title, description, musicUrl, hQMusicUrl, thumbMediaId, message);
    }

    @Override
    public String generateNewsMessage(List<NewsMessage> newsMessageList, Message message) {
        return sendMessageHandler.generateNewsMessage(newsMessageList, message);
    }

    @Override
    public Group createGroup(String groupName) {
        return userGroupHandler.createGroup(groupName);
    }

    @Override
    public List<Group> findAllGroup() {
        return userGroupHandler.findAllGroup();
    }

    @Override
    public int findGroup(String openId) {
        return userGroupHandler.findGroup(openId);
    }

    @Override
    public boolean updateGroupName(Integer groupId, String groupName) {
        return userGroupHandler.updateGroupName(groupId, groupName);
    }

    @Override
    public boolean moveToAnotherGroup(String openId, Integer groupId) {
        return userGroupHandler.moveToAnotherGroup(openId, groupId);
    }

    @Override
    public boolean remarkUserName(String openId, String givenName) {
        return userHandler.remarkUserName(openId, givenName);
    }

    @Override
    public UserInfo getUserInfo(String openId) {
        return userHandler.getUserInfo(openId);
    }

    @Override
    public FollowerList getFollowerList(String nextOpenId) {
        return userHandler.getFollowerList(nextOpenId);
    }
}

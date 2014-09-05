package wechat4j;

import wechat4j.message.Message;
import wechat4j.message.NewsMessage;
import wechat4j.support.bean.AccessToken;
import wechat4j.user.bean.FollowerList;
import wechat4j.user.bean.UserInfo;
import wechat4j.user.group.bean.Group;

import java.io.InputStream;
import java.util.List;

/**
 * @author renbin.fang.
 * @date 2014/9/5.
 */
public class WeChatImpl extends AbstractWechat {
    @Override
    public AccessToken getAccessToken() {
        return accessTokenGetter.getAccessToken();
    }

    @Override
    public AccessToken getAccessToken(String appId, String appSecret) {
        return accessTokenGetter.getAccessToken(appId, appSecret);
    }

    @Override
    public boolean createMenu(String accessToken, String jsonData) {
        return menuHandler.createMenu(accessToken, jsonData);
    }

    @Override
    public String queryMenu(String accessToken) {
        return null;
    }

    @Override
    public boolean deleteMenu(String accessToken) {
        return false;
    }

    @Override
    public String generateTextMessage(String content, Message message) {
        return null;
    }

    @Override
    public String generateImageMessage(String mediaId, Message message) {
        return null;
    }

    @Override
    public String generateVoiceMessage(String mediaId, Message message) {
        return null;
    }

    @Override
    public String generateVideoMessage(String mediaId, String title, String description, Message message) {
        return null;
    }

    @Override
    public String generateMusicMessage(String title, String description, String musicUrl, String hQMusicUrl, String thumbMediaId, Message message) {
        return null;
    }

    @Override
    public String generateNewsMessage(List<NewsMessage> newsMessageList, Message message) {
        return null;
    }

    @Override
    public boolean createGroup(String groupName) {
        return false;
    }

    @Override
    public List<Group> findAllGroup() {
        return null;
    }

    @Override
    public int findGroup(String openId) {
        return 0;
    }

    @Override
    public boolean updateGroupName(Long groupId, String groupName) {
        return false;
    }

    @Override
    public boolean moveToAnotherGroup(String openId, Integer groupId) {
        return false;
    }

    @Override
    public boolean remarkUserName(String openId, String givenName) {
        return false;
    }

    @Override
    public UserInfo getUserInfo(String openId) {
        return null;
    }

    @Override
    public FollowerList getFollowerList(String nextOpenId) {
        return null;
    }

    @Override
    public <T extends Message> T getMessage(InputStream inputStream) {
        return null;
    }
}

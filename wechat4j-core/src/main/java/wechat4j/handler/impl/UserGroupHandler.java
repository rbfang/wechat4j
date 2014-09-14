package wechat4j.handler.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import wechat4j.bean.user.Group;
import wechat4j.bean.user.UserGroup;
import wechat4j.bean.user.UserInfo;
import wechat4j.handler.IUserGroupHandler;
import wechat4j.support.Configuration;
import wechat4j.support.HttpsRequest;
import wechat4j.support.WechatException;

import java.util.ArrayList;
import java.util.List;

/**
 * CreateGroup
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public class UserGroupHandler implements IUserGroupHandler {
    private Configuration conf;
    private final Log logger = LogFactory.getLog(getClass());

    @Override
    public Group createGroup(String groupName) {
        String url = BASE_URL + "groups/create?access_token=" + conf.getAccessToken();
        Group group = new Group(groupName);
        UserGroup userGroup = new UserGroup(group);

        JSONObject resultJsonObject = HttpsRequest.doPostRequest(url, new JSONObject(userGroup).toString());
        JSONObject groupObj = resultJsonObject.getJSONObject("group");

        int groupId = groupObj.getInt("id");
        group.setId(groupId);
        group.setCount(0);

        return group;
    }

    @Override
    public List<Group> findAllGroup() {
        String url = BASE_URL + "groups/get?access_token=" + conf.getAccessToken();
        JSONObject result = HttpsRequest.doGetRequest(url);

        JSONArray jsonArray = result.getJSONArray("groups");
        List<Group> groupList = new ArrayList<Group>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Group group = new Group(
                    jsonObject.getInt("id"),
                    jsonObject.getString("name"),
                    jsonObject.getInt("count")
            );

            groupList.add(group);
        }

        return groupList;
    }

    @Override
    public int findGroup(String openId) {
        String url = BASE_URL + "groups/getid?access_token=" + conf.getAccessToken();
        UserInfo userInfo = new UserInfo(openId);

        JSONObject resultJsonObject = HttpsRequest.doPostRequest(url, new JSONObject(userInfo).toString());
        int groupId = 0;
        try {
            groupId = resultJsonObject.getInt("groupid");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return groupId;
    }

    @Override
    public boolean updateGroupName(Integer groupId, String groupName) {
        String url = BASE_URL + "groups/update?access_token=" + conf.getAccessToken();
        Group group = new Group(groupId, groupName);
        UserGroup userGroup = new UserGroup(group);

        System.out.println(new JSONObject(userGroup).toString());

        JSONObject resultJsonObject = HttpsRequest.doPostRequest(url, new JSONObject(userGroup).toString());
        boolean success = false;
        int errcode = resultJsonObject.getInt("errcode");
        if (errcode == 0) {
            success = true;
        }

        return success;
    }

    @Override
    public boolean moveToAnotherGroup(String openId, Integer groupId) {
        String url = BASE_URL + "groups/members/update?access_token=" + conf.getAccessToken();
        UserGroup.MovingGroup movingGroup = new UserGroup.MovingGroup(openId, groupId);

        JSONObject jsonObject = HttpsRequest.doPostRequest(url, new JSONObject(movingGroup).toString());

        boolean success = false;
        int errcode = jsonObject.getInt("errcode");
        if (errcode == 0) {
            success = true;
        }

        return success;
    }
}

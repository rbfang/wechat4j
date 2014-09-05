package wechat4j.user.group;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import wechat4j.support.Configuration;
import wechat4j.support.HttpsRequest;
import wechat4j.support.WechatException;
import wechat4j.user.bean.UserInfo;
import wechat4j.user.group.bean.Group;
import wechat4j.user.group.bean.UserGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * CreateGroup
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public class UserGroupOperator implements IUserGroupOperator {
    private Configuration conf;
    private final Log logger = LogFactory.getLog(getClass());

    @Override
    public boolean createGroup(String groupName) {
        String url = BASE_URL + "groups/create?access_token=" + conf.getAccessToken();
        Group group = new Group("朋友");
        UserGroup userGroup = new UserGroup(group);

        JSONObject resultJsonObject = HttpsRequest.doPostRequest(url, new JSONObject(userGroup).toString());
        boolean success = false;
        try {
            int errcode = resultJsonObject.getInt("errcode");
            throw new WechatException("");
        } catch (WechatException e) {

            System.out.println(e.toString());

            success = true;
        }

        return success;
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
                    jsonObject.getLong("id"),
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
    public boolean updateGroupName(Long groupId, String groupName) {
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

    public void setConf(Configuration conf) {
        this.conf = conf;
    }
}

package wechat4j.user.group;

import org.json.JSONArray;
import org.json.JSONObject;
import wechat4j.support.HttpsRequest;
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
    private static String ACCESS_TOKEN = "T4aRsNv_95OQy4GFLR2oT2vKT5qc7R608_yB46KBIq2hWGYw1h3Os9vhwtgo9pSKA4yocQ29Y5JYu9cT9B3w5A";

    //TODO TO handle exceptions

    @Override
    public boolean createGroup(String groupName) {
        String url = BASE_URL + "groups/create?access_token=" + ACCESS_TOKEN;
        final Group group = new Group("朋友");
        final UserGroup userGroup = new UserGroup() {
            {
                this.setGroup(group);
            }
        };

        JSONObject resultJsonObject = HttpsRequest.doPostRequest(url, new JSONObject(userGroup).toString());
        boolean success = false;
        try {
            int errcode = resultJsonObject.getInt("errcode");
        } catch (Exception e) {
            System.out.println(e.toString());

            success = true;
        }

        return success;
    }

    @Override
    public List<Group> findAllGroup() {
        String url = BASE_URL + "groups/get?access_token=" + ACCESS_TOKEN;
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
        String url = BASE_URL + "groups/getid?access_token=" + ACCESS_TOKEN;
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
        String url = BASE_URL + "groups/update?access_token=" + ACCESS_TOKEN;
        Group group = new Group(groupId, groupName);
        UserGroup userGroup = new UserGroup();
        userGroup.setGroup(group);

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
        String url = BASE_URL + "groups/members/update?access_token=" + ACCESS_TOKEN;
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

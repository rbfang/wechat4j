package wechat4j.user.group;


import wechat4j.user.group.bean.UserGroup;

import java.util.List;

/**
 * Operation of user groups
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public interface IUserGroupOperator {
    static final String CREATE = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=ACCESS_TOKEN";
    static final String QUERY = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=ACCESS_TOKEN";
    static final String GET_ID = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=ACCESS_TOKEN";
    static final String UPDATE = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=ACCESS_TOKEN";
    static final String MOVE_TO = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=ACCESS_TOKEN";

    boolean createGroup(String groupName);

    List<UserGroup> findAllGroup();

    int findGroup(String openId);

    boolean updateGroupName(UserGroup userGroupgroup);

    boolean moveToAnotherGroup(String openId, long groupId);
}

package wechat4j.user.group;


import wechat4j.support.RequestUrl;
import wechat4j.user.group.bean.UserGroup;

import java.util.List;

/**
 * Operation of user groups
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public interface IUserGroupOperator extends RequestUrl{
    boolean createGroup(String groupName);

    List<UserGroup> findAllGroup();

    int findGroup(String openId);

    boolean updateGroupName(UserGroup userGroupgroup);

    boolean moveToAnotherGroup(String openId, long groupId);
}

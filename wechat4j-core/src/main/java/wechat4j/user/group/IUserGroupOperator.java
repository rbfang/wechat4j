package wechat4j.user.group;


import wechat4j.support.RequestUrl;
import wechat4j.user.group.bean.Group;
import wechat4j.user.group.bean.UserGroup;

import java.util.List;

/**
 * Operation of user groups
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public interface IUserGroupOperator extends RequestUrl {
    boolean createGroup(String groupName);

    List<Group> findAllGroup();

    int findGroup(String openId);

    boolean updateGroupName(Long groupId, String groupName);

    boolean moveToAnotherGroup(String openId, Integer groupId);
}

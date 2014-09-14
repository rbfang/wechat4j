package wechat4j.handler;


import wechat4j.support.RequestUrl;
import wechat4j.bean.user.Group;

import java.util.List;

/**
 * Operation of user groups
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public interface IUserGroupHandler extends RequestUrl {
    Group createGroup(String groupName);

    List<Group> findAllGroup();

    int findGroup(String openId);

    boolean updateGroupName(Integer groupId, String groupName);

    boolean moveToAnotherGroup(String openId, Integer groupId);
}

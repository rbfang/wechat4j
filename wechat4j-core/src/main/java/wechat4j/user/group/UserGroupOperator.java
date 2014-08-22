package wechat4j.user.group;

import wechat4j.user.group.bean.UserGroup;

import java.util.List;

/**
 * CreateGroup
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public class UserGroupOperator implements IUserGroupOperator {
    @Override
    public boolean createGroup(String groupName) {
        return false;
    }

    @Override
    public List<UserGroup> findAllGroup() {
        return null;
    }

    @Override
    public int findGroup(String openId) {
        return 0;
    }

    @Override
    public boolean updateGroupName(UserGroup userGroupgroup) {
        return false;
    }

    @Override
    public boolean moveToAnotherGroup(String openId, long groupId) {
        return false;
    }
}

package wechat4j.message.user;

import org.junit.Test;
import wechat4j.user.group.IUserGroupOperator;
import wechat4j.user.group.UserGroupOperator;
import wechat4j.user.group.bean.Group;

import java.util.List;

/**
 * UserGroupTest
 *
 * @author renbin.fang.
 * @date 2014/9/3.
 */
public class UserGroupTest {
    private static String accessToken = "4Ryp03nxnyrRrE2Mdkk9IarxE1E3mbKF2K5oXIheAApV_6nfU4Ah4G0oJbaZPsT_FVfqup6yq67Ri6xXJQNNCw";

    IUserGroupOperator userGroupOperator = new UserGroupOperator();

    @Test
    public void createGroupTest() {
        boolean success = userGroupOperator.createGroup("朋友");
        System.out.println("success=" + success);
    }

    @Test
    public void findGroupsTest() {
        List<Group> groupList = userGroupOperator.findAllGroup();

        for (Group group : groupList) {
            System.out.println(group.toString());
        }
    }

    @Test
    public void findGroupTest() {
        String openId = "o2Jcyt0RQOshDEJVsBXV3xdrs1k0";
        int groupId = userGroupOperator.findGroup(openId);

        System.out.println("groupId=" + groupId);
    }

    @Test
    public void updateGroupTest() {
        Long id = 100L;
        String name = "大学同学";
        boolean success = userGroupOperator.updateGroupName(id, name);

        System.out.println("success=" + success);
    }

    @Test
    public void moveToAnotherGroup() {
        String oepnId = "o2Jcyt0RQOshDEJVsBXV3xdrs1k0";
        Integer groupId = 100;
        boolean success = userGroupOperator.moveToAnotherGroup(oepnId, groupId);

        System.out.println("success=" + success);
    }
}

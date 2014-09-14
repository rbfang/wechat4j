package wechat4j.handler;

import org.testng.Assert;
import org.testng.annotations.Test;
import wechat4j.WechatTestBase;
import wechat4j.bean.user.Group;
import wechat4j.handler.impl.UserGroupHandler;

import java.util.List;

/**
 * UserGroupTest
 *
 * @author renbin.fang.
 * @date 2014/9/3.
 */
@Test(enabled = true)
public class UserGroupHandlerTest extends WechatTestBase {
    IUserGroupHandler userGroupHandler = (IUserGroupHandler) handlerMap.get(UserGroupHandler.class.getName());

    @Test
    public void createGroupTest() {
        Group group = userGroupHandler.createGroup("朋友");

        Assert.assertTrue(group != null);
        Assert.assertTrue(group.getName() == "朋友");
        Assert.assertTrue(group.getId() > 0);
        Assert.assertTrue(group.getCount() == 0);
    }

    @Test
    public void findGroupsTest() {
        List<Group> groupList = userGroupHandler.findAllGroup();

        for (Group group : groupList) {
            System.out.println(group.toString());
        }
    }

    @Test
    public void findGroupTest() {
        String openId = "o2Jcyt0RQOshDEJVsBXV3xdrs1k0";
        int groupId = userGroupHandler.findGroup(openId);

        System.out.println("groupId=" + groupId);
    }

    @Test
    public void updateGroupTest() {
        Integer id = 100;
        String name = "大学同学";
        boolean success = userGroupHandler.updateGroupName(id, name);

        System.out.println("success=" + success);
    }

    @Test
    public void moveToAnotherGroup() {
        String oepnId = "o2Jcyt0RQOshDEJVsBXV3xdrs1k0";
        Integer groupId = 100;
        boolean success = userGroupHandler.moveToAnotherGroup(oepnId, groupId);

        System.out.println("success=" + success);
    }
}

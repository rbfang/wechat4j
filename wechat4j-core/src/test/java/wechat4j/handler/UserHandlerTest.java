package wechat4j.handler;

import org.testng.annotations.Test;
import wechat4j.WechatTestBase;
import wechat4j.bean.user.FollowerList;
import wechat4j.bean.user.UserInfo;
import wechat4j.handler.IUserHandler;
import wechat4j.handler.impl.UserHandler;

/**
 * RemarkingUserNameTest
 *
 * @author renbin.fang.
 * @date 2014/9/3.
 */
@Test(enabled = false)
public class UserHandlerTest extends WechatTestBase{
    private IUserHandler userHandler = (IUserHandler) handlerMap.get(UserHandler.class.getName());

    @Test
    public void remarkUserNameTest() {
        boolean success = userHandler.remarkUserName("o2Jcyt0RQOshDEJVsBXV3xdrs1k0", "pangzi");

        System.out.println("success = " + success);
    }

    @Test
    public void getUserInfo() {
        UserInfo userinfo = userHandler.getUserInfo("o2Jcyt0RQOshDEJVsBXV3xdrs1k0");

        System.out.println(userinfo.toString());
    }

    @Test
    public void getFollowerList() {
        FollowerList followerList = userHandler.getFollowerList("");

        System.out.println(followerList.toString());
    }
}

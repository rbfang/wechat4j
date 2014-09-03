package wechat4j.message.user;

import org.testng.annotations.Test;
import wechat4j.message.Configuration;
import wechat4j.user.IUserOperator;
import wechat4j.user.UserOperator;
import wechat4j.user.bean.UserInfo;

/**
 * RemarkingUserNameTest
 *
 * @author renbin.fang.
 * @date 2014/9/3.
 */
@Test(enabled = false)
public class RemarkingUserNameTest extends Configuration {
    private static String ACCESS_TOKEN = "";
    private IUserOperator userOperator = new UserOperator();

    @Test
    public void remarkUserNameTest() {
        boolean success = userOperator.remarkUserName("o2Jcyt0RQOshDEJVsBXV3xdrs1k0", "pangzi");

        System.out.println("success = " + success);
    }

    @Test
    public void getUserInfo() {
        UserInfo userinfo = userOperator.getUserInfo("o2Jcyt0RQOshDEJVsBXV3xdrs1k0");

        System.out.println(userinfo.toString());
    }
}

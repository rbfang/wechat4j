package wechat4j.handler;

import org.testng.annotations.Test;
import wechat4j.WechatTestBase;
import wechat4j.support.AccessTokenHandler;
import wechat4j.support.bean.AccessToken;

@Test(enabled = false)
public class AccessTokenHandlerTest extends WechatTestBase {
    private AccessTokenHandler accessTokenHandler = (AccessTokenHandler) handlerMap.get(AccessTokenHandler.class.getName());

    @Test
    public void getAccessTokenTest() {
        AccessToken accessToken = accessTokenHandler.getAccessToken();
        System.out.println(accessToken.toString());
    }
}

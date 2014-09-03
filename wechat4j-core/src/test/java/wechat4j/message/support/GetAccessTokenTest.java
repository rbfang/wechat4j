package wechat4j.message.support;

import org.testng.annotations.Test;
import wechat4j.support.AccessTokenGetter;
import wechat4j.support.bean.AccessToken;

@Test(enabled = false)
public class GetAccessTokenTest {

    @Test
    public void getAccessTokenTest() {
        AccessTokenGetter tokenGetter = new AccessTokenGetter("wxd30e31bfd8c207ee", "d0f9c44269c0282a1a7337efea1950a1");

        AccessToken accessToken = tokenGetter.getAccessToken();
        System.out.println(accessToken.toString());
    }
}

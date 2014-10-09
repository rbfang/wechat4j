package wechat4j.support;

import org.json.JSONObject;
import wechat4j.support.bean.AccessToken;

import java.util.Date;

/**
 * 获取access token
 */
public class AccessTokenHandler implements
        IAccessTokenHandler,
        HttpResponseCode,
        RequestUrl {

    private Configuration conf;

    @Override
    public AccessToken getAccessToken() {
        String requestUrl = ACCESS_TOKEN_URL.replace("${APPID}", conf.getAppId()).replace("${APPSECRET}", conf.getAppSecret());

        JSONObject jsonObject = HttpsRequest.doGetRequest(requestUrl);

        AccessToken accessToken = new AccessToken();
        accessToken.setGotTokenTime(new Date());
        accessToken.setAccessToken(jsonObject.getString("access_token"));
        accessToken.setExpiresIn(jsonObject.getLong("expires_in"));

        return accessToken;
    }
}

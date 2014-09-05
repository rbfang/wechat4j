package wechat4j.support;

import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import wechat4j.support.bean.AccessToken;

import java.util.Date;

public class AccessTokenGetter implements
        IAccessTokenGetter,
        HttpResponseCode,
        RequestUrl {

    private String appId;
    private String appSecret;

    public AccessTokenGetter() {
    }

    /**
     * Constructor
     *
     * @param appId
     * @param appSecret
     */
    public AccessTokenGetter(String appId, String appSecret) {
        this.appId = appId;
        this.appSecret = appSecret;
    }

    @Override
    public AccessToken getAccessToken() {
        String requestUrl = ACCESS_TOKEN_URL.replace("${APPID}", appId).replace("${APPSECRET}", appSecret);

        JSONObject jsonObject = HttpsRequest.doGetRequest(requestUrl);

        AccessToken accessToken = new AccessToken();
        accessToken.setGotTokenTime(new Date());
        accessToken.setAccessToken(jsonObject.getString("access_token"));
        accessToken.setExpiresIn(jsonObject.getLong("expires_in"));

        return accessToken;
    }

    @Override
    public AccessToken getAccessToken(String appId, String appSecret) {
        if (StringUtils.isEmpty(this.appId)) {
            this.appId = appId;
        }

        if (StringUtils.isEmpty(this.appSecret)) {
            this.appSecret = appSecret;
        }

        return getAccessToken();
    }
}

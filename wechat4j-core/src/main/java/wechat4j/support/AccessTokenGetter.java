package wechat4j.support;

import org.json.JSONObject;
import wechat4j.support.bean.AccessToken;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Date;

public class AccessTokenGetter implements HttpResponseCode, RequestUrl {
    private String appId;
    private String appSecret;

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


    public AccessToken getAccessToken() {
        String requestUrl = ACCESS_TOKEN_URL.replace("${APPID}", appId).replace("${APPSECRET}", appSecret);

        JSONObject jsonObject = HttpsRequest.doGetReuqest(requestUrl);

        AccessToken accessToken = new AccessToken();
        accessToken.setGotTokenTime(new Date());
        accessToken.setAccessToken(jsonObject.getString("access_token"));
        accessToken.setExpiresIn(jsonObject.getLong("expires_in"));

        return accessToken;
    }
}

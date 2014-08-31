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

        JSONObject jsonObject = new JSONObject(getResponse(requestUrl));

        AccessToken accessToken = new AccessToken();
        accessToken.setGotTokenTime(new Date());
        accessToken.setAccessToken(jsonObject.getString("access_token"));
        accessToken.setExpiresIn(jsonObject.getLong("expires_in"));

        return accessToken;
    }


    private String getResponse(String requstUrl) {
        String returnString = null;
        // 获取接口内容
        try {
            TrustManager[] trustManagers = {new MyX509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, trustManagers, new SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requstUrl);
            System.setProperty("https.protocols", "SSLv3");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setSSLSocketFactory(ssf);

            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);

            // 设置请求方式（GET/POST）
            connection.setRequestMethod("GET");
            connection.connect();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuffer stringBuffer = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                stringBuffer.append(line);
            }

            reader.close();
            connection.disconnect();

            returnString = stringBuffer.toString();


        } catch (IOException e) {
            System.err.println(e.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }

        return returnString;
    }
}

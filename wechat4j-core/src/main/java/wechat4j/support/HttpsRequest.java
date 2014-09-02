package wechat4j.support;

import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public final class HttpsRequest {
    private static String GET = "GET";
    private static String POST = "POST";

    public static JSONObject doPostRequest(String requestUrl, String outPutString) {
        return new JSONObject(request(requestUrl, POST, outPutString));
    }

    public static JSONObject doGetRequest(String requestUrl) {
        return new JSONObject(request(requestUrl, GET, null));
    }

    public static String request(String requstUrl, String requestMethod, String outPutString) {
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
            connection.setRequestMethod(requestMethod);

            if (StringUtils.equals(GET, requestMethod)) {
                connection.connect();
            }

            if (StringUtils.isNotEmpty(outPutString) && StringUtils.equals(POST, requestMethod)) {
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(outPutString.getBytes("UTF-8"));
                outputStream.close();
            }

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

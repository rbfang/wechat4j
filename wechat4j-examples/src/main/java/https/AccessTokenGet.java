package https;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;

import java.io.IOException;

public class AccessTokenGet {

    public static void main(String[] args) {
        HttpClient httpclient;
        String url;
        GetMethod method;
        ProtocolSocketFactory fcty;

        url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxd30e31bfd8c207ee&secret=d0f9c44269c0282a1a7337efea1950a1";

        //https 证书
        fcty = new MySecureProtocolSocketFactory();
        Protocol.registerProtocol("https", new Protocol("https", fcty, 443));

        httpclient = new HttpClient();
        method = new GetMethod(url);// get调用
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));

        try {
            int statusCode = httpclient.executeMethod(method);

            if (statusCode != HttpStatus.SC_OK) {
                System.out.println(statusCode + ": " + method.getStatusLine());
            } else {
                System.out.println(new String(method.getResponseBody(), "UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
    }
}

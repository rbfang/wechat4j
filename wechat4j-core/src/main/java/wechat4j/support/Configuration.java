package wechat4j.support;

/**
 * Configuration
 *
 * @author renbin.fang.
 * @date 2014/9/4.
 */
public interface Configuration {
    String getAccessToken();

    String getAppId();

    String getAppSecret();

    void setAppSecret(String appId,
                      String appSecret);
}

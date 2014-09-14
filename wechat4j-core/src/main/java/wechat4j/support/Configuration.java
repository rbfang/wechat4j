package wechat4j.support;

import wechat4j.support.bean.AppSecret;
import wechat4j.support.bean.AuthToken;
import wechat4j.support.bean.Signature;

/**
 * Configuration
 *
 * @author renbin.fang.
 * @date 2014/9/4.
 */
public interface Configuration {
    String getAccessToken();

    AppSecret getAppSecret();

    String getAppId();

    String getAppSercret();

    void setAppSecret(String appId,
                      String appSercret);
}

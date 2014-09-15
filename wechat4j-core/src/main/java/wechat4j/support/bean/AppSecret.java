package wechat4j.support.bean;

import java.io.Serializable;

/**
 * AppSecret
 *
 * @author renbin.fang.
 * @date 2014/8/24.
 */
public class AppSecret implements Serializable {
    private String appId;
    private String appSecret;

    public AppSecret() {
    }

    public AppSecret(String appId, String appSecret) {
        this.appId = appId;
        this.appSecret = appSecret;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    @Override
    public String toString() {
        return "AppSecret{" +
                "appId='" + appId + '\'' +
                ", appSecret='" + appSecret + '\'' +
                '}';
    }
}

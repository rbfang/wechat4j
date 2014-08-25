package wechat4j;

import java.io.Serializable;

/**
 * AppSecret
 *
 * @author renbin.fang.
 * @date 2014/8/24.
 */
public class AppSecret implements Serializable {
    private String appId;
    private String appSercret;

    public AppSecret() {
    }

    public AppSecret(String appId, String appSercret) {
        this.appId = appId;
        this.appSercret = appSercret;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSercret() {
        return appSercret;
    }

    public void setAppSercret(String appSercret) {
        this.appSercret = appSercret;
    }
}

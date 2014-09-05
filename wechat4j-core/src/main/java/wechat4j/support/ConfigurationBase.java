package wechat4j.support;

import wechat4j.support.bean.AccessToken;
import wechat4j.support.bean.AppSecret;
import wechat4j.support.bean.AuthToken;
import wechat4j.support.bean.Signature;

/**
 * @author renbin.fang.
 * @date 2014/9/4.
 */
public class ConfigurationBase implements Configuration {
    private ConfigurationBase configurationBase;
    private AccessToken accessToken;

    @Override
    public String getAccessToken() {
        return accessToken.getAccessToken();
    }

    @Override
    public Signature getSignature() {
        return null;
    }

    @Override
    public AppSecret getAppSecret() {
        return null;
    }

    @Override
    public AuthToken getAuthToken() {
        return null;
    }

    @Override
    public Configuration getInstance() {
        if (configurationBase == null) {
            configurationBase = new ConfigurationBase();
            configurationBase.setAccessToken(requsetAccessToken());
        }

        return configurationBase;
    }

    //TODO 这里硬编码不行哦，需要想个办法哦。
    private AccessToken requsetAccessToken() {
        AccessTokenGetter tokenGetter = new AccessTokenGetter("wxd30e31bfd8c207ee", "d0f9c44269c0282a1a7337efea1950a1");

        this.accessToken = tokenGetter.getAccessToken();

        return this.accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }
}

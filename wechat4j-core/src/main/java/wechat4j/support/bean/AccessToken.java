package wechat4j.support.bean;

import java.util.Date;

/**
 * AccessToken
 *
 * @author renbin.fang.
 * @date 2014/8/25.
 */
public class AccessToken {
    private String accessToken;
    private Date gotTokenTime;

    // 获取后有效期为7200秒
    private Date validTime;

    public AccessToken() {
    }

    public AccessToken(String accessToken, Date gotTokenTime, Date validTime) {
        this.accessToken = accessToken;
        this.gotTokenTime = gotTokenTime;
        this.validTime = validTime;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Date getGotTokenTime() {
        return gotTokenTime;
    }

    public void setGotTokenTime(Date gotTokenTime) {
        this.gotTokenTime = gotTokenTime;
    }

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }
}

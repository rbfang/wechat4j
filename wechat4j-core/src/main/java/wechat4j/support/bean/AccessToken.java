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
    private Long ExpiresIn;

    public AccessToken() {
    }

    public AccessToken(String accessToken, Date gotTokenTime, Long expiresIn) {
        this.accessToken = accessToken;
        this.gotTokenTime = gotTokenTime;
        ExpiresIn = expiresIn;
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

    public Long getExpiresIn() {
        return ExpiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        ExpiresIn = expiresIn;
    }

    @Override
    public String toString() {
        return "AccessToken{" +
                "accessToken='" + accessToken + '\'' +
                ", gotTokenTime=" + gotTokenTime +
                ", ExpiresIn=" + ExpiresIn +
                '}';
    }
}

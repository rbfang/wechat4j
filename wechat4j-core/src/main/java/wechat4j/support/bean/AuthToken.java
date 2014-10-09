package wechat4j.support.bean;

import java.io.Serializable;

/**
 * AuthToken
 *
 * @author renbin.fang.
 * @date 2014/8/24.
 */
public class AuthToken implements Serializable {
    private String url;
    private String token;

    public AuthToken() {
    }

    public AuthToken(String url, String token) {
        this.url = url;
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

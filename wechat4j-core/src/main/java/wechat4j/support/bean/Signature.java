package wechat4j.support.bean;

/**
 * Signature
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public class Signature {
    private String token;
    private String signature;
    private String timestamp;
    private String nonce;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }
}

package wechat4j.util;

import org.apache.commons.lang.StringUtils;
import wechat4j.support.bean.Signature;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * CheckSignatureUtil
 *
 * @author renbin.fang.
 * @date 2014/8/24.
 */
public class CheckSignatureUtil {
    /**
     * 验证消息的真实性
     *
     * @param signature
     * @return true or false
     */
    public static boolean checkSignature(Signature signature) {
        String wechatSignature = signature.getSignature();
        String timestamp = signature.getTimestamp();
        String nonce = signature.getNonce();

        if (StringUtils.isEmpty(wechatSignature) || StringUtils.isEmpty(timestamp) || StringUtils.isEmpty(nonce)) {
            return false;
        }

        String[] stringArray = new String[]{signature.getToken(), timestamp, nonce};
        java.util.Arrays.sort(stringArray);
        StringBuilder signatureBuilder = new StringBuilder();
        for (String string : stringArray) {
            signatureBuilder.append(string);
        }

        return StringUtils.equals(wechatSignature, sha1(signatureBuilder.toString()));
    }

    /**
     * sha1
     *
     * @param key
     * @return string
     */
    private static String sha1(String key) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            md.update(key.getBytes());
            String pwd = new BigInteger(1, md.digest()).toString(16);
            return pwd;
        } catch (Exception e) {
            e.printStackTrace();
            return key;
        }
    }
}

package wechat4j;

import java.io.Serializable;

/**
 * WechatFactory
 *
 * @author renbin.fang.
 * @date 2014/9/4.
 */
public class WechatFactory implements Serializable {
    private static Wechat WECHAT = new WeChatImpl();

    public static Wechat newInstance() {
        return WECHAT;
    }

    //private constructor prevents instantiation
    private WechatFactory() {
        throw new Error("Do not instance :(");
    }
}

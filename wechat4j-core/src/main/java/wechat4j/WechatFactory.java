package wechat4j;

import java.io.Serializable;
import java.lang.reflect.Constructor;

/**
 * WechatFactory
 *
 * @author renbin.fang.
 * @date 2014/9/4.
 */
public class WechatFactory implements Serializable {
    private static Wechat wechat = new WeChatImpl();

    public static Wechat newInstance() {
        return wechat;
    }

    private WechatFactory() {
        throw new Error("Do not instance :(");
    }
}

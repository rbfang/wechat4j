package wechat4j;

import java.io.Serializable;
import java.lang.reflect.Constructor;

/**
 * @author renbin.fang.
 * @date 2014/9/4.
 */
public class WechatFactory implements Serializable {
    private static Constructor<Wechat> constructor;
    private static String CLAZZ = "wechat4j.menu.MenuHandler";

    //TODO return wechat new instance
}

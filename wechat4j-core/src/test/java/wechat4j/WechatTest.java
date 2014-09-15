package wechat4j;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * @author renbin.fang.
 * @date 2014/9/5.
 */
public class WechatTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
//        String clazzName = "wechat4j.support.bean.AccessToken";
//
//        Field field = Class.forName(clazzName).getDeclaredField("accessToken");
//        field.setAccessible(true);
//        Object obj = Class.forName(clazzName).newInstance();
//        field.set(obj, "aaa");
//
//        System.out.println(field.get(obj));

        Date date = new Date();
        System.out.println(date);
        System.out.println(new Date(date.getTime() + 7200 * 1000));
    }
}

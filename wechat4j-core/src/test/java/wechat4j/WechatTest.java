package wechat4j;

import wechat4j.bean.user.Group;

import java.util.List;

/**
 * WechatTest
 *
 * @author renbin.fang.
 * @date 2014/9/5.
 */
public class WechatTest {
    public static void main(String[] args) {
        Wechat wechat = WechatFactory.newInstance();
        List<Group> groups = wechat.findAllGroup();

        for (Group group : groups) {
            System.out.println(group.toString());
        }
    }
}

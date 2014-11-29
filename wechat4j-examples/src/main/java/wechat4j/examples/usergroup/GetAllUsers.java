package wechat4j.examples.usergroup;

import wechat4j.Wechat;
import wechat4j.WechatFactory;
import wechat4j.bean.user.FollowerList;

/**
 * GetAllUsers
 *
 * @author renbin.fang.
 * @date 2014/9/24.
 */
public class GetAllUsers {
    public static void main(String[] args) {
        Wechat wechat = WechatFactory.newInstance();

        FollowerList followerList = wechat.getFollowerList("");

        System.out.println(followerList.toString());
    }
}

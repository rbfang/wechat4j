package wechat4j.user;

import wechat4j.user.bean.FollowerList;
import wechat4j.user.bean.UserInfo;

/**
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public interface IUserOperator {
    static String GET_USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
    static String GET_FOLLOWER_LIST_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";

    UserInfo getUserInfo(String openId);

    FollowerList getFollwerList(String nextOpenId);
}

package wechat4j.user;

import wechat4j.user.bean.FollowerList;
import wechat4j.user.bean.UserInfo;

/**
 * UserOperator
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public class UserOperator implements IUserOperator {

    @Override
    public UserInfo getUserInfo(String openId) {
        return null;
    }

    @Override
    public FollowerList getFollwerList(String nextOpenId) {
        return null;
    }
}

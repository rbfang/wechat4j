package wechat4j.user;

import wechat4j.user.bean.FollowerList;
import wechat4j.user.bean.UserInfo;

/**
 * IUserOperator
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public interface IUserOperator {
    /**
     * 设置备注名
     *
     * @param openId
     * @param givenName
     * @return
     */
    boolean remarkUserName(String openId, String givenName);

    /**
     * 获取用户信息
     *
     * @param openId
     * @return
     * @see
     */
    UserInfo getUserInfo(String openId);

    /**
     * 获取用户列表
     *
     * @param nextOpenId
     * @return
     */
    FollowerList getFollwerList(String nextOpenId);
}

package wechat4j.handler;

import wechat4j.bean.user.FollowerList;
import wechat4j.bean.user.UserInfo;

/**
 * IUserHandler
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public interface IUserHandler {
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
    FollowerList getFollowerList(String nextOpenId);
}
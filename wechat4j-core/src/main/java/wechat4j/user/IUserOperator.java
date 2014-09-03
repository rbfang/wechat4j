package wechat4j.user;

import wechat4j.user.bean.FollowerList;
import wechat4j.user.bean.UserInfo;

/**
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
//     * @see http://mp.weixin.qq.com/wiki/index.php?title=%E8%AE%BE%E7%BD%AE%E7%94%A8%E6%88%B7%E5%A4%87%E6%B3%A8%E5%90%8D%E6%8E%A5%E5%8F%A3
     */
    boolean remarkUserName(String openId, String givenName);

    /**
     * 获取用户信息
     *
     * @param openId
     * @return
//     * @see http://mp.weixin.qq.com/wiki/index.php?title=%E8%8E%B7%E5%8F%96%E7%94%A8%E6%88%B7%E5%9F%BA%E6%9C%AC%E4%BF%A1%E6%81%AF(UnionID%E6%9C%BA%E5%88%B6)
     */
    UserInfo getUserInfo(String openId);

    FollowerList getFollwerList(String nextOpenId);
}

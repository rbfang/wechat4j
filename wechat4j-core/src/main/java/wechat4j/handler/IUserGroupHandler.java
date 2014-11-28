package wechat4j.handler;


import wechat4j.support.RequestUrl;
import wechat4j.bean.user.Group;

import java.util.List;

/**
 * 用户组处理接口
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public interface IUserGroupHandler extends RequestUrl {
    /**
     * 创建用户组
     *
     * @param groupName 组名称
     * @return {@link wechat4j.bean.user.Group}
     */
    Group createGroup(String groupName);

    /**
     * 返回所有组信息
     *
     * @return {@link java.util.List<wechat4j.bean.user.Group>}
     */
    List<Group> findAllGroup();

    /**
     * 查询用户所在的组​
     *
     * @param openId 用户的Openid
     * @return 用户所属的groupid
     */
    int findGroup(String openId);

    /**
     * 更新组名称
     *
     * @param groupId   分组id，由微信分配
     * @param groupName 分组名字（30个字符以内）
     * @return 更新成功：true 更新失败：false ​
     */
    boolean updateGroupName(Integer groupId, String groupName);

    /**
     * 移动用户分组
     *
     * @param openId  用户唯一标识符
     * @param groupId 分组id
     * @return 移动成功：true 移动失败：false
     */
    boolean moveToAnotherGroup(String openId, Integer groupId);
}

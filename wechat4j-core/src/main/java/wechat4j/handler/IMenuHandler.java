package wechat4j.handler;

/**
 * 创建用户组接口
 *
 * @author renbin.fang.
 * @date 2014/9/5.
 */
public interface IMenuHandler {
    /**
     * 创建菜单
     *
     * @param jsonData 菜单Json
     * @return
     */
    boolean createMenu(String jsonData);

    /**
     * 查询菜单
     *
     * @return 菜单Json
     */
    String queryMenu();

    /**
     * 删除菜单
     *
     * @return 删除成功：true 删除失败：false
     */
    boolean deleteMenu();
}

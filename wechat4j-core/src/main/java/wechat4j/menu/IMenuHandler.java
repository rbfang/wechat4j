package wechat4j.menu;

/**
 * @author renbin.fang.
 * @date 2014/9/5.
 */
public interface IMenuHandler {
    boolean createMenu(String accessToken, String jsonData);

    String queryMenu(String accessToken);

    boolean deleteMenu(String accessToken);
}

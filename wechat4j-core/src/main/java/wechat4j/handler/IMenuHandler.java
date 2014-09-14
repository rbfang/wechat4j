package wechat4j.handler;

/**
 * @author renbin.fang.
 * @date 2014/9/5.
 */
public interface IMenuHandler {
    boolean createMenu(String jsonData);

    String queryMenu();

    boolean deleteMenu();
}

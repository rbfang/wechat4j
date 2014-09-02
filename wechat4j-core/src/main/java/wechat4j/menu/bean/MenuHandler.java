package wechat4j.menu.bean;

import wechat4j.support.HttpResponseCode;
import wechat4j.support.HttpsRequest;
import wechat4j.support.RequestUrl;

/**
 * MenuHandler
 *
 * @author renbin.fang.
 * @date 2014/9/1.
 */
public class MenuHandler implements HttpResponseCode, RequestUrl {

    //TODO 重构此段代码
    public static String createMenu(String accessToken, String jsonDate) {
        String url = BASE_URL + "menu/create?access_token=" + accessToken;

        return HttpsRequest.doPostRequest(url, jsonDate).toString();
    }

    public static String queryMenu(String accessToken) {
        String url = BASE_URL + "menu/get?access_token=" + accessToken;

        return HttpsRequest.doGetReuqest(url).toString();
    }

    public static String deleteMenu(String accessToken) {
        String url = BASE_URL + "menu/delete?access_token=" + accessToken;

        return HttpsRequest.doGetReuqest(url).toString();
    }
}

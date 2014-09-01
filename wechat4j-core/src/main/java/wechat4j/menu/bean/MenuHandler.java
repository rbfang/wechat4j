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

    public static String createMenu(String accessToken, String jsonDate) {
        String url = BASE_URL + "menu/create?access_token=" + accessToken;

        return HttpsRequest.doPostRequest(url, jsonDate).toString();
    }
}

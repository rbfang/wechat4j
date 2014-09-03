package wechat4j.menu.bean;

import org.json.JSONObject;
import wechat4j.support.HttpResponseCode;
import wechat4j.support.HttpsRequest;
import wechat4j.support.RequestUrl;
import wechat4j.support.WechatException;

/**
 * MenuHandler
 *
 * @author renbin.fang.
 * @date 2014/9/1.
 */
public class MenuHandler implements HttpResponseCode, RequestUrl {
    private static final String CREATE = "menu/create?access_token=";
    private static final String QUERY = "menu/get?access_token=";
    private static final String DELETE = "menu/delete?access_token=";

    public static boolean createMenu(String accessToken, String jsonDate) {
        String url = BASE_URL + CREATE + accessToken;

        String result = HttpsRequest.doPostRequest(url, jsonDate).toString();
        JSONObject resultJsonObject = new JSONObject(result);

        int errCode = resultJsonObject.getInt("errcode");
        String errmsg = resultJsonObject.getString("errmsg");

        if (errCode != SUCCESS) {
            return false;
        }

        return true;
    }

    public static String queryMenu(String accessToken) {
        String url = BASE_URL + QUERY + accessToken;

        return HttpsRequest.doGetRequest(url).toString();
    }

    public static boolean deleteMenu(String accessToken) {
        String url = BASE_URL + DELETE + accessToken;

        String result = HttpsRequest.doGetRequest(url).toString();
        JSONObject resultJsonObject = new JSONObject(result);

        int errCode = resultJsonObject.getInt("errcode");
        String errmsg = resultJsonObject.getString("errmsg");

        if (errCode != SUCCESS) {
            return false;
        }

        return true;
    }
}

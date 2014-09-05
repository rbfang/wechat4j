package wechat4j.menu;

import org.json.JSONObject;
import wechat4j.support.HttpResponseCode;
import wechat4j.support.HttpsRequest;
import wechat4j.support.RequestUrl;

/**
 * MenuHandler
 *
 * @author renbin.fang.
 * @date 2014/9/1.
 */
public class MenuHandler implements
        IMenuHandler,
        HttpResponseCode,
        RequestUrl {

    private static final String CREATE = "menu/create?access_token=";
    private static final String QUERY = "menu/get?access_token=";
    private static final String DELETE = "menu/delete?access_token=";



    @Override
    public boolean createMenu(String accessToken, String jsonDate) {
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

    @Override
    public String queryMenu(String accessToken) {
        String url = BASE_URL + QUERY + accessToken;

        return HttpsRequest.doGetRequest(url).toString();
    }

    @Override
    public boolean deleteMenu(String accessToken) {
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

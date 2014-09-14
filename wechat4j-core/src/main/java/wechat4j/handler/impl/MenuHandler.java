package wechat4j.handler.impl;

import org.json.JSONObject;
import wechat4j.handler.IMenuHandler;
import wechat4j.support.Configuration;
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

    private static final String CREATE = BASE_URL + "menu/create?access_token=";
    private static final String QUERY = BASE_URL + "menu/get?access_token=";
    private static final String DELETE = BASE_URL + "menu/delete?access_token=";

    private Configuration conf;

    @Override
    public boolean createMenu(String jsonDate) {
        String url = CREATE + conf.getAccessToken();

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
    public String queryMenu() {
        String url = QUERY + conf.getAccessToken();

        return HttpsRequest.doGetRequest(url).toString();
    }

    @Override
    public boolean deleteMenu() {
        String url = DELETE + conf.getAccessToken();

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

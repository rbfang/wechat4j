package wechat4j.handler.impl;

import org.json.JSONArray;
import org.json.JSONObject;
import wechat4j.bean.user.FollowerList;
import wechat4j.bean.user.RemarkingUserName;
import wechat4j.bean.user.UserInfo;
import wechat4j.handler.IUserHandler;
import wechat4j.support.Configuration;
import wechat4j.support.HttpResponseCode;
import wechat4j.support.HttpsRequest;
import wechat4j.support.RequestUrl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * UserHandler
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public class UserHandler implements IUserHandler, HttpResponseCode, RequestUrl {
    private Configuration conf;

    @Override
    public boolean remarkUserName(String openId, String givenName) {
        String url = BASE_URL + "user/info/updateremark?access_token=" + conf.getAccessToken();
        RemarkingUserName remarkingUserName = new RemarkingUserName(openId, givenName);

        JSONObject resultJsonObject = HttpsRequest.doPostRequest(url, new JSONObject(remarkingUserName).toString());
        boolean success = false;
        int errcode = resultJsonObject.getInt("errcode");
        if (errcode == SUCCESS) {
            success = true;
        }

        return success;
    }

    @Override
    public UserInfo getUserInfo(String openId) {
        String url = BASE_URL + "user/info?access_token=" + conf.getAccessToken() + "&openid=" + openId + "&lang=zh_CN";

        JSONObject resultJsonObject = HttpsRequest.doGetRequest(url);

        UserInfo userInfo = new UserInfo();
        userInfo.setSubscribe(resultJsonObject.getInt("subscribe"));
        userInfo.setOpenid(resultJsonObject.getString("openid"));
        userInfo.setNickname(resultJsonObject.getString("nickname"));
        userInfo.setSex(resultJsonObject.getInt("sex"));
        userInfo.setLanguage(resultJsonObject.getString("language"));
        userInfo.setCity(resultJsonObject.getString("city"));
        userInfo.setProvince(resultJsonObject.getString("province"));
        userInfo.setCountry(resultJsonObject.getString("country"));
        userInfo.setHeadimgurl(resultJsonObject.getString("headimgurl"));
        userInfo.setSubscribeTime(new Date(resultJsonObject.getLong("subscribe_time")));
        //TODO 此处获取UNION ID需要做出判断
//      只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。详见：获取用户个人信息（UnionID机制）
//      userInfo.setUnionid(resultJsonObject.getString("unionid"));

        return userInfo;
    }

    @Override
    public FollowerList getFollowerList(String nextOpenId) {
        String url = BASE_URL + "user/get?access_token=" + conf.getAccessToken() + "&net_openid=" + nextOpenId;
        JSONObject resultJsonObject = HttpsRequest.doGetRequest(url);

        List<String> openIdList = new ArrayList<String>();
        JSONObject dataJsonObject = resultJsonObject.getJSONObject("data");
        JSONArray openIdJsonArray = dataJsonObject.getJSONArray("openid");
        for (int i = 0; i < openIdJsonArray.length(); i++) {
            openIdList.add(openIdJsonArray.get(i).toString());
        }

        FollowerList followerList = new FollowerList();
        followerList.setTotal(resultJsonObject.getLong("total"));
        followerList.setCount(resultJsonObject.getInt("count"));
        followerList.setOpenIdList(openIdList);
        followerList.setNextOpenId(resultJsonObject.getString("next_openid"));

        return followerList;
    }
}

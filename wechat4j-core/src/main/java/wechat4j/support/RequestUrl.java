package wechat4j.support;

public interface RequestUrl {
    String BASE_URL = "https://api.weixin.qq.com/cgi-bin/";

    String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=${APPID}&secret=${APPSECRET}";
    String CUSTOM_MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=${ACCESS_TOKEN}";

    String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=${ACCESS_TOKEN}";
    String MENU_QUERY_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=${ACCESS_TOKEN}";
    String MENU_DELETE_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=${ACCESS_TOKEN}";

    String GROUP_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=${ACCESS_TOKEN}";
    String GROUP_QUERY_URL = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=${ACCESS_TOKEN}";
    String GROUP_USER_URL = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=${ACCESS_TOKEN}";
    String GROUP_UPDATE_URL = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=${ACCESS_TOKEN}";
    String GROUP_MOVE_USER_URL = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=${ACCESS_TOKEN}";

    String UPDATE_REMARK_URL = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=${ACCESS_TOKEN}";
    String USER_INFO_GET_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=${ACCESS_TOKEN}&openid=${OPENID}&lang=zh_CN";
    String FLLOWERS_GET_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=${ACCESS_TOKEN}&next_openid=${NEXT_OPENID}";
}

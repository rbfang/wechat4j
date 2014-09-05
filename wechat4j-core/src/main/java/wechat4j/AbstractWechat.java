package wechat4j;

import wechat4j.menu.IMenuHandler;
import wechat4j.menu.MenuHandler;
import wechat4j.message.handler.*;
import wechat4j.support.AccessTokenGetter;
import wechat4j.support.IAccessTokenGetter;
import wechat4j.user.IUserOperator;
import wechat4j.user.UserOperator;
import wechat4j.user.group.IUserGroupOperator;
import wechat4j.user.group.UserGroupOperator;

/**
 * @author renbin.fang.
 * @date 2014/9/5.
 */
public abstract class AbstractWechat implements Wechat {
    protected static IAccessTokenGetter accessTokenGetter;
    protected static MessageHandler recivedMessageHandler;
    protected static MessageHandler recivedEventHandler;
    protected static IMenuHandler menuHandler;
    protected static ISendMessageHandler sendMessageHandler;
    protected static IUserGroupOperator userGroupOperator;
    protected static IUserOperator userOperator;

    static {
        accessTokenGetter = new AccessTokenGetter();
        recivedMessageHandler = new ReceivedMessageHandler();
        recivedEventHandler = new EventMessageHandler();
        menuHandler = new MenuHandler();
        sendMessageHandler = new SendMessageHandler();
        userGroupOperator = new UserGroupOperator();
        userOperator = new UserOperator();
    }
}

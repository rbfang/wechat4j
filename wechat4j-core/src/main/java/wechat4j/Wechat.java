package wechat4j;

import wechat4j.menu.IMenuHandler;
import wechat4j.message.handler.ISendMessageHandler;
import wechat4j.message.handler.MessageHandler;
import wechat4j.support.IAccessTokenGetter;
import wechat4j.user.IUserOperator;
import wechat4j.user.group.IUserGroupOperator;

/**
 * Wechat
 *
 * @author renbin.fang.
 * @date 2014/9/4.
 */
public interface Wechat extends java.io.Serializable,
        IAccessTokenGetter,
        MessageHandler,
        IMenuHandler,
        ISendMessageHandler,
        IUserGroupOperator,
        IUserOperator {
}

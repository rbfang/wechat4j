package wechat4j;

import wechat4j.handler.IMenuHandler;
import wechat4j.handler.IUserGroupHandler;
import wechat4j.handler.IUserHandler;
import wechat4j.message.handler.ISendMessageHandler;
import wechat4j.message.handler.MessageHandler;

/**
 * Wechat
 *
 * @author renbin.fang.
 * @date 2014/9/4.
 */
public interface Wechat extends java.io.Serializable,
        MessageHandler,
        ISendMessageHandler,
        IMenuHandler,
        IUserGroupHandler,
        IUserHandler {
}

package wechat4j.message.handler;

import wechat4j.message.Message;

import java.io.InputStream;

/**
 * MessageHandler
 *
 * @author renbin.fang.
 * @date 2014/9/5.
 */
public interface MessageHandler {
    Message getMessage(InputStream inputStream);
}

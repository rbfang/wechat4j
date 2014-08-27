package wechat4j.message.handler;

import wechat4j.message.Message;

import java.io.InputStream;

/**
 * Message handler
 *
 * @author renbin.fang.
 * @date 2014/8/21.
 */
public interface MessageHandler {
    Message getMessage(InputStream inputStream);
}

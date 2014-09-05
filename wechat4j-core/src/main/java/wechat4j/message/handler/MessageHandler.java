package wechat4j.message.handler;

import wechat4j.message.Message;

import java.io.InputStream;

/**
 * @author renbin.fang.
 * @date 2014/9/5.
 */
public interface MessageHandler {
    <T extends Message> T getMessage(InputStream inputStream);
}

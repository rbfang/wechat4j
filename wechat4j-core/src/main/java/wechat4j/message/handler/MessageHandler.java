package wechat4j.message.handler;

import java.io.InputStream;

/**
 * Message handler
 *
 * @author renbin.fang.
 * @date 2014/8/21.
 */
public interface MessageHandler {
    <T> T getMessage(InputStream inputStream);
}

package wechat4j.message.handler;

import wechat4j.message.Message;

import java.io.InputStream;

/**
 * 接收消息处理器
 *
 * @author renbin.fang.
 * @date 2014/9/5.
 */
public interface MessageHandler {
    /**
     * 将接收到的消息转换成Message
     *
     * @param inputStream 微信服务器传过来的
     * @return {@link wechat4j.message.Message}
     */
    Message getMessage(InputStream inputStream);
}

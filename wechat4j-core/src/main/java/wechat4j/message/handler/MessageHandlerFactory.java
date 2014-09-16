package wechat4j.message.handler;

import org.apache.commons.lang.StringUtils;

/**
 * Message handler factory
 *
 * @author renbin.fang.
 * @date 2014/8/21.
 */
public class MessageHandlerFactory {
    private static MessageHandler commonMessageHandler;
    private static MessageHandler eventMessageHandler;

    public enum HandlerType {
        COMMON, EVENT;
    }

    public static MessageHandler getMessageHandler(String value) {
        MessageHandler messageHandler = null;
        if (StringUtils.equals(value, HandlerType.COMMON.toString())) {
            if (messageHandler == null) {
                messageHandler = new CommonMessageHandler();
            }
        } else if (StringUtils.equals(value, HandlerType.EVENT.toString())) {
            if (messageHandler == null) {
                messageHandler = new EventMessageHandler();
            }
        }

        return messageHandler;
    }
}

package wechat4j.message.handler;

import org.apache.commons.lang.StringUtils;

/**
 * 消息处理器工厂类
 *
 * @author renbin.fang.
 * @date 2014/8/21.
 */
public class MessageHandlerFactory {
    private MessageHandlerFactory() {
        throw new Error("You should not instance this factory. :(");
    }

    public enum HandlerType {
        COMMON, EVENT;
    }

    private static class CommonMessageHandlerHelper {
        // 普通消息处理器
        private static final MessageHandler INSTANCE = new CommonMessageHandler();
    }

    private static class EventMessageHandlerHelper {
        // 事件消息处理器
        private static final MessageHandler INSTANCE = new EventMessageHandler();
    }

    public static MessageHandler getMessageHandler(String value) {
        MessageHandler messageHandler = null;
        if (StringUtils.equals(value, HandlerType.COMMON.toString()))
            messageHandler = CommonMessageHandlerHelper.INSTANCE;
        else if (StringUtils.equals(value, HandlerType.EVENT.toString())) {
            messageHandler = EventMessageHandlerHelper.INSTANCE;
        }

        return messageHandler;
    }
}

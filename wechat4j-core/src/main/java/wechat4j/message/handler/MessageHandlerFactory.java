package wechat4j.message.handler;

/**
 * Message handler factory
 *
 * @author renbin.fang.
 * @date 2014/8/21.
 */
public class MessageHandlerFactory {
    private static MessageHandler messageHandler = new ReceivedMessageHandler();
    private static MessageHandler eventMessageHandler = new EventMessageHandler();
    private static ISendMessageHandler sendMessageHandler = new SendMessageHandler();

    private MessageHandlerFactory() {
        throw new Error("Do not instance :(");
    }

    public static MessageHandler getMessageHandler() {
        return messageHandler;
    }

    public static MessageHandler getEventMessageHandler() {
        return eventMessageHandler;
    }

    public static ISendMessageHandler getSendMessageHandler() {
        return sendMessageHandler;
    }
}

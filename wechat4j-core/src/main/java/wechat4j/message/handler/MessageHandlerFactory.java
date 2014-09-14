package wechat4j.message.handler;

/**
 * Message handler factory
 *
 * @author renbin.fang.
 * @date 2014/8/21.
 */
public class MessageHandlerFactory {
    private static AbstractReceiveMessageHandler messageHandler = new ReceivedMessageHandler();
    private static AbstractReceiveMessageHandler eventMessageHandler = new EventMessageHandler();
    private static ISendMessageHandler sendMessageHandler = new SendMessageHandler();

    private MessageHandlerFactory() {
        throw new Error("Do not instance :(");
    }

    public static AbstractReceiveMessageHandler getMessageHandler() {
        return messageHandler;
    }

    public static AbstractReceiveMessageHandler getEventMessageHandler() {
        return eventMessageHandler;
    }

    public static ISendMessageHandler getSendMessageHandler() {
        return sendMessageHandler;
    }
}

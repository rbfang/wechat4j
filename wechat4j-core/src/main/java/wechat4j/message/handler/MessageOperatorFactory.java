package wechat4j.message.handler;

/**
 * Message operator factory
 *
 * @author renbin.fang.
 * @date 2014/8/21.
 */
public class MessageOperatorFactory {
    private static IReceiveMessageHandler receiveMessageHandler;
    private static ISendMessageHandler sendMessageOperator;

    static {
        receiveMessageHandler = new ReceiveMessageHandler();
        sendMessageOperator = new SendMessageHandler();
    }

    public static IReceiveMessageHandler getRecivedMessageOperator() {
        return receiveMessageHandler;
    }

    public static ISendMessageHandler getSendMessageOperator() {
        return sendMessageOperator;
    }
}

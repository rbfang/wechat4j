package wechat4j.message.handler;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.lang.StringUtils;
import wechat4j.message.Message;
import wechat4j.message.event.EventMessage;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 接收消息处理器抽象类，由
 * 1、普通消息 {@link wechat4j.message.handler.CommonMessageHandler}
 * 2、事件消息 {@link wechat4j.message.handler.EventMessageHandler}
 * 来实现，实现思路先判断事件类型，然后再根据消息类型来调用可以处理该类型消息的方法。
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public abstract class AbstractReceivingMessageHandler implements MessageHandler {
    /**
     * Parse Message from xml stream template method
     *
     * @param inputStream
     * @return Subclass of {@link wechat4j.message.Message}
     */
    public final <T extends Message> T getMessageFromInputStream(InputStream inputStream) {
        // 1st. Load new input stream
        reloadInputStream(inputStream);

        // 2nd. Get message header
        Message message = getMessageHeader();

        // 3rd. Find key word of method
        String keyWordOfMethod;
        if (StringUtils.equals(message.getMsgType(), Message.ReceivedType.EVENT.getValue())) {
            message = getEventMessageHeader(message);
            keyWordOfMethod = getEventMessageHeader(message).getEvent();
        } else {
            keyWordOfMethod = message.getMsgType();
        }

        // 4th. Get class using reflection and invoking the method
        Object obj = null;
        try {
            Class<?> clazz = Class.forName(getClassName());

            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {

                if (!isMessageMethod(keyWordOfMethod, method)) {
                    continue;
                }

                try {
                    method.setAccessible(true);
                    obj = method.invoke(clazz.newInstance(), message);

                    break;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return (T) obj;
    }

    /**
     * If the method should be invoked
     *
     * @param keyWordOfMethod
     * @param method
     * @return true or false
     */
    private boolean isMessageMethod(String keyWordOfMethod, Method method) {
        return method.getName().startsWith("get")
                && StringUtils.containsIgnoreCase(method.getName(), keyWordOfMethod);
    }


    /**
     * Reloads input stream
     *
     * @param inputStream
     * @throws org.apache.commons.configuration.ConfigurationException
     */
    protected void reloadInputStream(InputStream inputStream) {
        getXmlReader().clear();
        try {
            getXmlReader().load(inputStream);
        } catch (ConfigurationException e) {
            System.out.println(e);
        }
    }


    /**
     * Get method header from input stream
     *
     * @return {@link wechat4j.message.Message}
     */
    protected Message getMessageHeader() {
        return new Message(
                getXmlReader().getString("ToUserName"),
                getXmlReader().getString("FromUserName"),
                getXmlReader().getString("CreateTime"),
                getXmlReader().getString("MsgType"),
                getXmlReader().getString("MsgId"));
    }

    /**
     * Get event message header
     *
     * @param message {@link wechat4j.message.Message}
     * @return {@link wechat4j.message.event.EventMessage}
     */
    protected EventMessage getEventMessageHeader(Message message) {
        String event = getXmlReader().getString("Event");

        return new EventMessage(message, event);
    }

    protected abstract XMLConfiguration getXmlReader();

    protected abstract String getClassName();
}

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
 * <p>Receiving message handler abstract class.</p>
 * <p>Few steps to handle new messages.</p>
 * <p>
 * step1. Loading input stream into {@link org.apache.commons.configuration.XMLConfiguration}.<br/>
 * step2. Getting message header which is every message has.<br/>
 * step3. Invoking method which can handle the type of message.<br/>
 * step3. Return {@link wechat4j.message.Message}.<br/>
 * </p>
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public abstract class AbstractReceivingMessageHandler implements MessageHandler {
    /**
     * Parse Message from xml stream
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
    //TODO 这里判断不够明确清楚。使用正则表达式来判断应该不错。
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
     * @return
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
     * @return
     */
    protected EventMessage getEventMessageHeader(Message message) {
        String event = getXmlReader().getString("Event");

        return new EventMessage(message, event);
    }

    protected abstract XMLConfiguration getXmlReader();

    protected abstract String getClassName();
}
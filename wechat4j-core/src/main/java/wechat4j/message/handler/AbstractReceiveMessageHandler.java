package wechat4j.message.handler;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.lang.StringUtils;
import wechat4j.message.Message;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * IReceiveMessageOperator
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public abstract class AbstractReceiveMessageHandler implements MessageHandler {
    private final static String clazz = "wechat4j.message.handler.ReceiveMessageHandler";

    /**
     * Parse Message from xml stream
     *
     * @param msgType
     * @param inputStream
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public final Message getMessageFromXml(String msgType, InputStream inputStream) {
        Message message = null;

        Class<?> claz = null;
        try {
            claz = Class.forName(clazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Method[] methods = claz.getMethods();
        for (Method method : methods) {
            if (isMessageMethod(msgType, method)) {
                try {
                    message = (Message) method.invoke(claz.newInstance(), inputStream);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }

        return message;
    }

    /**
     * is right one ?
     *
     * @param msgType
     * @param method
     * @return
     */
    private boolean isMessageMethod(String msgType, Method method) {
        return method.getName().startsWith("get")
                && StringUtils.containsIgnoreCase(method.getName(), msgType);
    }

    /**
     * Put message header into the base class.
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

    protected abstract XMLConfiguration getXmlReader();
}

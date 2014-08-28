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
 * IReceiveMessageOperator
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public abstract class AbstractReceiveMessageHandler implements MessageHandler {
    /**
     * Parse Message from xml stream
     *
     * @param clazzStr
     * @param msgType
     * @param inputStream
     * @return
     */
    public final Message getMessageFromXml(String clazzStr, String msgType, InputStream inputStream) {
        Message message = null;

        Class<?> claz = null;
        try {
            claz = Class.forName(clazzStr);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //TODO
        Method[] methods = claz.getMethods();
        for (Method method : methods) {
            if (isMessageMethod(msgType, method)) {
                try {
                    System.out.println(method.getName());
                    message = (Message) method.invoke(claz.newInstance(), inputStream);

                    break;
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

    public final EventMessage getEventMessageFromXml(String clazzStr, String msgType, InputStream inputStream) {
        EventMessage eventMessage = null;

        Class<?> claz = null;
        try {
            claz = Class.forName(clazzStr);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //TODO
        Method[] methods = claz.getMethods();
        for (Method method : methods) {
            if (isMessageMethod(msgType, method)) {
                try {
                    System.out.println(method.getName());
                    eventMessage = (EventMessage) method.invoke(claz.newInstance(), inputStream);

                    break;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }

        return eventMessage;
    }

    private boolean isEventMsgType(String msgType, Method method) {
        return StringUtils.equals(msgType, Message.ReceivedType.EVENT.getValue())
                && method.getName().startsWith("get")
                && method.getName().contains("EventMessage");
    }

    /**
     * is right one ?
     *
     * @param msgType
     * @param method
     * @return
     */
    private boolean isMessageMethod(String msgType, Method method) {
        System.out.println("method.getName().startsWith(\"get\")" + method.getName().startsWith("get"));
        System.out.println("StringUtils.containsIgnoreCase(method.getName(), msgType)" + StringUtils.containsIgnoreCase(method.getName(), msgType));
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

    protected EventMessage getEventMessageHeader() {
        return new EventMessage(getMessageHeader(), getXmlReader().getString("Event"));
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

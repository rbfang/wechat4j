package wechat4j.message.handler;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import wechat4j.message.Message;

import java.io.InputStream;

/**
 * IReceiveMessageOperator
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public abstract class AbstractReceiveMessageHandler implements MessageHandler {
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

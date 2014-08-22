package name.frb.wechat4j;

import wechat4j.menu.bean.Button;
import wechat4j.message.event.EventMessage;
import wechat4j.message.event.SubscibeEventMessage;
import wechat4j.message.handler.ISendMessageHandler;
import wechat4j.message.handler.MessageOperatorFactory;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static void main(String[] args) {
        ISendMessageHandler sendMessageHandler = MessageOperatorFactory.getSendMessageOperator();
        String textMessageTemplate = sendMessageHandler.generateTextMessage("");
        System.out.println(textMessageTemplate);

        SubscibeEventMessage subscibeEventMessage = new SubscibeEventMessage();
        subscibeEventMessage.setEvent(EventMessage.EventType.CLICK.getValue());

        Button.ViewButton viewButton = new Button().new ViewButton();
        viewButton.setUrl("http://www.baidu.com");

        Button.ClickButton clickButton = new Button().new ClickButton();

        clickButton.setKey("");
    }
}

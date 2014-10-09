package wechat4j.examples.menu;

import org.json.JSONObject;
import wechat4j.Wechat;
import wechat4j.WechatFactory;
import wechat4j.bean.menu.Button;

/**
 * @author renbin.fang.
 * @date 2014/9/17.
 */
public class CreateMenu {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Wechat wechat = WechatFactory.newInstance();

        CreateMenu createMenu = CreateMenu.class.newInstance();

        wechat.createMenu(createMenu.gnerateMenuJson());
    }

    private String gnerateMenuJson() {
        Button.ClickButton clickButton = new Button.ClickButton();
        clickButton.setKey("V1001_TODAY_MUSIC");
        clickButton.setName("今日歌曲");

        new Button.ClickButton("今日歌曲", "");

        Button.ClickButton clickButton1 = new Button.ClickButton();
        clickButton1.setKey("V1001_TODAY_MUSIC");
        clickButton1.setName("歌手简介");


        Button.ViewButton subviewButton1 = new Button.ViewButton();
        Button.ViewButton subviewButton2 = new Button.ViewButton();

        subviewButton1.setName("搜索");
        subviewButton1.setUrl("http://www.soso.com/");

        subviewButton2.setName("视频");
        subviewButton2.setUrl("http://v.qq.com/");

        Button.ClickButton subclickButton = new Button.ClickButton();
        subclickButton.setName("赞一下我们");
        subclickButton.setKey("V1001_GOOD");

        Button.SubButton subButton = new Button.SubButton();
        subButton.setName("菜单");
        subButton.setSub_button(new Button[]{subviewButton1, subviewButton2, subclickButton});

        Button.MainButton mainButton = new Button.MainButton();
        mainButton.setButton(new Button[]{clickButton, clickButton1, subButton});

        return new JSONObject(mainButton).toString();
    }
}

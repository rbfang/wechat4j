package wechat4j.message.menu;

import org.json.JSONObject;
import org.junit.Test;
import wechat4j.menu.bean.Button;
import wechat4j.menu.bean.MenuHandler;

/**
 * ButtonHandlerTest
 *
 * @author renbin.fang.
 * @date 2014/9/1.
 */
public class ButtonHandlerTest {

    @Test
    public void createMenuTest() {
        String accessToken = "ZwLx4qm_L_Kf3Nm7YPENBVeKXjVrn0caQa4zj2AnZhrelWZ3GCYNrkK3Q-DjrvpAKBpzxdTQNZlW1suhBuRP_w";
        String jsonDate = gnerateJson();

        System.out.println(MenuHandler.createMenu(accessToken, jsonDate));
    }

    /**
     * 生成创建菜单的JSON数据
     *
     * @return
     */
    private String gnerateJson() {
        Button.ClickButton clickButton = new Button.ClickButton();
        clickButton.setKey("V1001_TODAY_MUSIC");
        clickButton.setName("今日歌曲");

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
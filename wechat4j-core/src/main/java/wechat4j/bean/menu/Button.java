package wechat4j.bean.menu;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Button，自定义菜单按钮封装bean。
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 * @see //http://mp.weixin.qq.com/wiki/index.php?title=%E8%87%AA%E5%AE%9A%E4%B9%89%E8%8F%9C%E5%8D%95%E5%88%9B%E5%BB%BA%E6%8E%A5%E5%8F%A3
 */
public class Button implements Serializable {
    /**
     * 按钮名称
     */
    private String name;

    /**
     * Constructor
     */
    public Button() {
    }

    /**
     * 跳转URL按钮
     */
    public static class ViewButton extends Button {
        private String type = ButtonType.VIEW.getValue();
        private String url;

        public ViewButton() {
        }

        public ViewButton(String name, String url) {
            super.setName(name);

            this.url = url;
        }

        public String getType() {
            return type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "ViewButton{" +
                    "type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    "} " + super.toString();
        }
    }


    /**
     * 点击类型按钮
     * 用户点击click类型按钮后，微信服务器会通过消息接口推送消息类型为event
     */
    public static class ClickButton extends Button {
        private String type = ButtonType.CLICK.getValue();
        private String key;

        public ClickButton() {
        }

        public ClickButton(String name, String key) {
            super.setName(name);
            this.key = key;
        }

        public String getType() {
            return type;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "ClickButton{" +
                    "type='" + type + '\'' +
                    ", key='" + key + '\'' +
                    "} " + super.toString();
        }
    }

    /**
     * 菜单子按钮
     */
    public static class SubButton extends Button {
        private Button[] sub_button;

        private static int MAX = 5;
        private int length = 5;
        private int sizeOfInstance = 0;

        public void add(Button button) {
            if (sub_button[MAX - 1] != null) return;

            int cursor = MAX - length;
            sub_button[cursor] = button;
            length--;
            sizeOfInstance++;
        }

        public void add(List<? extends Button> buttons) {
            for (int i = 0; i < buttons.size(); i++) {
                sub_button[i] = buttons.get(i);
                sizeOfInstance++;
            }
        }

        public SubButton() {
            sub_button = new Button[MAX];
        }

        /**
         * 获取按钮数量
         */
        public int size() {
            return this.sizeOfInstance;
        }

        public Button[] getSub_button() {
            return sub_button;
        }

        public void setSub_button(Button[] sub_button) {
            this.sub_button = sub_button;
        }

        @Override
        public String toString() {
            return "SubButton{" +
                    "sub_button=" + Arrays.toString(sub_button) +
                    "} " + super.toString();
        }
    }

    /**
     * 主菜单按钮，包括：一级菜单按钮和二级菜单的按钮
     */
    public static class MainButton {
        private Button[] button;

        public Button[] getButton() {
            return button;
        }

        public void setButton(Button[] button) {
            this.button = button;
        }

        @Override
        public String toString() {
            return "MainButton{" +
                    "button=" + Arrays.toString(button) +
                    '}';
        }
    }

    /**
     * 按钮类型枚举类
     */
    public enum ButtonType {
        VIEW("view"), CLICK("click");

        private String value;

        ButtonType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Button{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}


package wechat4j.menu.bean;

import java.io.Serializable;

/**
 * Button
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public class Button implements Serializable {
    private String name;

    public Button() {
    }

    public static class ViewButton extends Button {
        private String type = ButtonType.VIEW.getValue();
        private String url;

        public String getType() {
            return type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }


    public static class ClickButton extends Button {
        private String type = ButtonType.CLICK.getValue();
        private String key;

        public String getType() {
            return type;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }

    public static class SubButton extends Button {
        private Button[] sub_button;

        public Button[] getSub_button() {
            return sub_button;
        }

        public void setSub_button(Button[] sub_button) {
            this.sub_button = sub_button;
        }
    }

    public static class MainButton {
        private Button[] button;

        public Button[] getButton() {
            return button;
        }

        public void setButton(Button[] button) {
            this.button = button;
        }
    }

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


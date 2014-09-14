package wechat4j.bean.menu;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

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
         * 获取实例数量
         *
         * @return
         */
        public int getSizeOfInstance() {
            return this.sizeOfInstance;
        }

        public int size() {
            return this.sub_button.length;
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

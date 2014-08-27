package wechat4j.menu.bean;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Button
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public class Button implements Serializable {
    private String type;
    private String name;

    public Button() {
    }

    public Button(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public static class ViewButton extends Button {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public ViewButton() {
        }
    }


    public static class ClickButton extends Button {
        private String key;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("type", type)
                .append("name", name)
                .toString();
    }
}


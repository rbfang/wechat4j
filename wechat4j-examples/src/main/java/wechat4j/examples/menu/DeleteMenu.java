package wechat4j.examples.menu;

import wechat4j.Wechat;
import wechat4j.WechatFactory;

/**
 * DeleteMenu
 *
 * @author renbin.fang.
 * @date 2014/9/17.
 */
public class DeleteMenu {
    public static void main(String[] args) {
        Wechat wechat = WechatFactory.newInstance();
        System.out.println(wechat.deleteMenu());
    }
}

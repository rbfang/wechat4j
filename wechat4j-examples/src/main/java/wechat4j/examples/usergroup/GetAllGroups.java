package wechat4j.examples.usergroup;

import wechat4j.Wechat;
import wechat4j.WechatFactory;
import wechat4j.bean.user.Group;

import java.util.List;

public class GetAllGroups {
    public static void main(String[] args) {
        Wechat wechat = WechatFactory.newInstance();
        List<Group> groupList = wechat.findAllGroup();

        for (Group group : groupList) {
            System.out.println(group.toString());
        }

        System.exit(0);
    }
}

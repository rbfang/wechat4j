package wechat4j.user.group.bean;

/**
 * User group
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public class UserGroup extends Group {
    private Group group;

//TODO 不明白这里的构造方法为什么与内部静太类的构造方法冲突。
//    public UserGroup(Group group) {
//        this.group = group;
//    }
//
//    public UserGroup(Long id, String name, Integer count, Group group) {
//        super(id, name, count);
//        this.group = group;
//    }
//
//    public UserGroup(String name, Group group) {
//        super(name);
//        this.group = group;
//    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "UserGroup{" +
                "group=" + group +
                "} " + super.toString();
    }

    public static class UserGroups extends UserGroup {
        private Group[] groups;

        public UserGroups() {
        }

        public UserGroups(Group[] groups) {
            this.groups = groups;
        }

        public Group[] getGroups() {
            return groups;
        }

        public void setGroups(Group[] groups) {
            this.groups = groups;
        }
    }

    public static class MovingGroup {
        private String openid;
        private Integer to_groupid;

        public MovingGroup() {
        }

        public MovingGroup(String openid, Integer to_groupid) {
            this.openid = openid;
            this.to_groupid = to_groupid;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public Integer getTo_groupid() {
            return to_groupid;
        }

        public void setTo_groupid(Integer to_groupid) {
            this.to_groupid = to_groupid;
        }

        @Override
        public String toString() {
            return "MovingGroup{" +
                    "openid='" + openid + '\'' +
                    ", to_groupid=" + to_groupid +
                    "} " + super.toString();
        }
    }
}

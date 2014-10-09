package wechat4j.bean.user;

/**
 * User group
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 * @see [http://mp.weixin.qq.com/wiki/index.php?title=分组管理接口]
 */
public class UserGroup extends Group {
    private Group group;

    public UserGroup(Group group) {
        this.group = group;
    }

    public UserGroup(Integer id, String name, Integer count, Group group) {
        super(id, name, count);
        this.group = group;
    }

    public UserGroup(String name) {
        super(name);
    }

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

        public UserGroups(Group group, Group[] groups) {
            super(group);
            this.groups = groups;
        }

        public UserGroups(Integer id, String name, Integer count, Group group, Group[] groups) {
            super(id, name, count, group);
            this.groups = groups;
        }

        public UserGroups(String name, Group group, Group[] groups) {
            super(name);
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

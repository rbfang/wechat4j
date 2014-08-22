package wechat4j.user.group.bean;

/**
 * User group
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public class UserGroup {
    private long id;
    private String name;
    private Long count;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}

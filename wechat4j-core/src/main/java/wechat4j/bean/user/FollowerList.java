package wechat4j.bean.user;

import java.io.Serializable;
import java.util.List;

/**
 * Follower list
 *
 * @author renbin.fang.
 * @date 2014/8/22.
 */
public class FollowerList implements Serializable {
    private long total;
    private int count;
    private List<String> openIdList;
    private String nextOpenId;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<String> getOpenIdList() {
        return openIdList;
    }

    public void setOpenIdList(List<String> openIdList) {
        this.openIdList = openIdList;
    }

    public String getNextOpenId() {
        return nextOpenId;
    }

    public void setNextOpenId(String nextOpenId) {
        this.nextOpenId = nextOpenId;
    }

    @Override
    public String toString() {
        return "FollowerList{" +
                "total=" + total +
                ", count=" + count +
                ", openIdList=" + openIdList +
                ", nextOpenId='" + nextOpenId + '\'' +
                '}';
    }
}
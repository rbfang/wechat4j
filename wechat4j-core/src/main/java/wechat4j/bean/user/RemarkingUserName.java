package wechat4j.bean.user;

/**
 * @author renbin.fang.
 * @date 2014/9/3.
 */
public class RemarkingUserName {
//    "openid":"oDF3iY9ffA-hqb2vVvbr7qxf6A0Q",
//    "remark":"pangzi"

    private String openid;
    private String remark;

    public RemarkingUserName() {
    }

    public RemarkingUserName(String openid, String remark) {
        this.openid = openid;
        this.remark = remark;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "RemarkingUserName{" +
                "openid='" + openid + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}

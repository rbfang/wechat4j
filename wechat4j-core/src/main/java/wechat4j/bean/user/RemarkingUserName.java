package wechat4j.bean.user;

/**
 * RemarkingUserName
 *
 * @author renbin.fang.
 * @date 2014/9/3.
 * @see [http://mp.weixin.qq.com/wiki/index.php?title=设置用户备注名接口]
 */
public class RemarkingUserName {
    private String openid;
    private String remark;

    /**
     * Constructor
     */
    public RemarkingUserName() {
    }

    /**
     * Constructor
     *
     * @param openid
     * @param remark
     */
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

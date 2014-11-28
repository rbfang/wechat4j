package wechat4j.bean.user;

/**
 * 为用户设置备注名称
 *
 * @author renbin.fang.
 * @date 2014/9/3.
 * @see [http://mp.weixin.qq.com/wiki/index.php?title=设置用户备注名接口]
 */
public class RemarkingUserName {
    /**
     * 用户标识
     */
    private String openid;
    /**
     * 新的备注名，长度必须小于30字符
     */
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

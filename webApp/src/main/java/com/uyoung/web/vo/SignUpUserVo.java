package com.uyoung.web.vo;

/**
 * Desc:
 * <p/>Date: 2015-10-20
 * <br/>Time: 18:59
 * <br/>User: ylzhu
 */
public class SignUpUserVo {
    private Integer uid;
    private String avatar;
    private String nickName;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}

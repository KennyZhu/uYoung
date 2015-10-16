package com.uyoung.core.third.bean;

/**
 * Desc:第三方用户信息
 * <p/>Date: 2015-10-16
 * <br/>Time: 18:06
 * <br/>User: ylzhu
 */
public class ThirdUserInfo {
    private String userId;
    private String nickName;
    private String userAvatar;
    private int gender;
    private String genderDesc;

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getGenderDesc() {
        return genderDesc;
    }

    public void setGenderDesc(String genderDesc) {
        this.genderDesc = genderDesc;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

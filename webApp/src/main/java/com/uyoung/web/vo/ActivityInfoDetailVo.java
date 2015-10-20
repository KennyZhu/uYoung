package com.uyoung.web.vo;

import java.util.List;

/**
 * Desc:
 * <p/>Date: 2015-10-20
 * <br/>Time: 18:52
 * <br/>User: ylzhu
 */
public class ActivityInfoDetailVo {
    private int id;
    private int oriUserId;
    private String oriUserNickName;
    private String title;
    private String activityTypeDesc;
    private int needNum;
    private int day;
    private int mon;
    private String weekDesc;
    private String fromTime;
    private String toTime;
    private String address;
    private String oriUserAvatarUrl;
    private String local;
    private String statusDesc;
    private int feeType;
    private List<SignUpUserInfo> signUpUserInfos;

    public String getActivityTypeDesc() {
        return activityTypeDesc;
    }

    public void setActivityTypeDesc(String activityTypeDesc) {
        this.activityTypeDesc = activityTypeDesc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getFeeType() {
        return feeType;
    }

    public void setFeeType(int feeType) {
        this.feeType = feeType;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getMon() {
        return mon;
    }

    public void setMon(int mon) {
        this.mon = mon;
    }

    public int getNeedNum() {
        return needNum;
    }

    public void setNeedNum(int needNum) {
        this.needNum = needNum;
    }

    public String getOriUserAvatarUrl() {
        return oriUserAvatarUrl;
    }

    public void setOriUserAvatarUrl(String oriUserAvatarUrl) {
        this.oriUserAvatarUrl = oriUserAvatarUrl;
    }

    public int getOriUserId() {
        return oriUserId;
    }

    public void setOriUserId(int oriUserId) {
        this.oriUserId = oriUserId;
    }

    public String getOriUserNickName() {
        return oriUserNickName;
    }

    public void setOriUserNickName(String oriUserNickName) {
        this.oriUserNickName = oriUserNickName;
    }

    public List<SignUpUserInfo> getSignUpUserInfos() {
        return signUpUserInfos;
    }

    public void setSignUpUserInfos(List<SignUpUserInfo> signUpUserInfos) {
        this.signUpUserInfos = signUpUserInfos;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public String getWeekDesc() {
        return weekDesc;
    }

    public void setWeekDesc(String weekDesc) {
        this.weekDesc = weekDesc;
    }

    /**
     * 报名用户
     */
    class SignUpUserInfo {
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
}

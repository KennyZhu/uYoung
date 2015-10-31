package com.uyoung.core.api.model;

import java.util.Date;

public class ThirdUser {

    private Integer id;

    private Integer uid;

    private String thirdUid;

    private String accessToken;

    private String refreshToken;

    private String nickName;

    private int gender;

    private String city;

    private int userType;

    private String avatarUrl;

    private Date refreshTime;

    private Date createTime;


    private Date updateTime;


    private long expireIn;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getUid() {
        return uid;
    }


    public void setUid(Integer uid) {
        this.uid = uid;
    }


    public String getThirdUid() {
        return thirdUid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setThirdUid(String thirdUid) {
        this.thirdUid = thirdUid;
    }


    public String getAccessToken() {
        return accessToken;
    }


    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }


    public String getRefreshToken() {
        return refreshToken;
    }


    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }


    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }


    public Date getRefreshTime() {
        return refreshTime;
    }


    public void setRefreshTime(Date refreshTime) {
        this.refreshTime = refreshTime;
    }


    public Date getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Date getUpdateTime() {
        return updateTime;
    }


    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public long getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(long expireIn) {
        this.expireIn = expireIn;
    }

    @Override
    public String toString() {
        return "ThirdUser{" +
                "id=" + id +
                ", uid=" + uid +
                ", thirdUid='" + thirdUid + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", nickName='" + nickName + '\'' +
                ", gender=" + gender +
                ", city='" + city + '\'' +
                ", userType=" + userType +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", refreshTime=" + refreshTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", expireIn=" + expireIn +
                '}';
    }
}
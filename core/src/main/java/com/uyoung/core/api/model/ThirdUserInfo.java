package com.uyoung.core.api.model;

import java.util.Date;

public class ThirdUserInfo {

    private Integer id;

    private Integer uid;

    private String thirdUid;

    private String accessToken;

    private String refreshToken;

    private String nickName;

    private Boolean gender;

    private String avatarUrl;

    private Date refreshTime;


    private Date createTime;


    private Date updateTime;


    private String expireIn;


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

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
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


    public String getExpireIn() {
        return expireIn;
    }


    public void setExpireIn(String expireIn) {
        this.expireIn = expireIn;
    }
}
package com.uyoung.core.api.model;

import java.util.Date;

public class UserInfo {

    private Integer id;


    private String realName;


    private String nickName;


    private String password;


    private String email;


    private Boolean gender;


    private String avatarUrl;


    private String phone;


    private Integer address;


    private String company;


    private String position;


    private String equipment;


    private Byte style;


    private Date createTime;


    private Date updateTime;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getRealName() {
        return realName;
    }


    public void setRealName(String realName) {
        this.realName = realName;
    }


    public String getNickName() {
        return nickName;
    }


    public void setNickName(String nickName) {
        this.nickName = nickName;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
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


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Integer getAddress() {
        return address;
    }


    public void setAddress(Integer address) {
        this.address = address;
    }


    public String getCompany() {
        return company;
    }


    public void setCompany(String company) {
        this.company = company;
    }


    public String getPosition() {
        return position;
    }


    public void setPosition(String position) {
        this.position = position;
    }


    public String getEquipment() {
        return equipment;
    }


    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }


    public Byte getStyle() {
        return style;
    }


    public void setStyle(Byte style) {
        this.style = style;
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
}
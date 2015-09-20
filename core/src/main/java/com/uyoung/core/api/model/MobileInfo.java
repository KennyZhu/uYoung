package com.uyoung.core.api.model;

import java.util.Date;

public class MobileInfo {

    private Integer id;


    private Boolean platform;


    private String version;


    private String token;


    private String imei;


    private Integer userId;


    private Byte validate;


    private Date createTime;


    private Date updateTime;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Boolean getPlatform() {
        return platform;
    }


    public void setPlatform(Boolean platform) {
        this.platform = platform;
    }


    public String getVersion() {
        return version;
    }


    public void setVersion(String version) {
        this.version = version;
    }


    public String getToken() {
        return token;
    }


    public void setToken(String token) {
        this.token = token;
    }


    public String getImei() {
        return imei;
    }


    public void setImei(String imei) {
        this.imei = imei;
    }


    public Integer getUserId() {
        return userId;
    }


    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public Byte getValidate() {
        return validate;
    }


    public void setValidate(Byte validate) {
        this.validate = validate;
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
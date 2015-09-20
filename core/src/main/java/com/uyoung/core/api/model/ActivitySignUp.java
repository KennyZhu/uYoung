package com.uyoung.core.api.model;

import java.util.Date;

public class ActivitySignUp {

    private Integer id;


    private Integer activityId;


    private Integer userId;


    private Byte status;


    private Date createTime;


    private Date updateTime;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getActivityId() {
        return activityId;
    }


    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }


    public Integer getUserId() {
        return userId;
    }


    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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
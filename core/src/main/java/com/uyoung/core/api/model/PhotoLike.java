package com.uyoung.core.api.model;

import java.util.Date;

public class PhotoLike {

    private Integer id;


    private Integer photoId;


    private Integer userId;


    private Date createTime;


    private Date updateTime;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getPhotoId() {
        return photoId;
    }


    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }


    public Integer getUserId() {
        return userId;
    }


    public void setUserId(Integer userId) {
        this.userId = userId;
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
package com.uyoung.core.api.model;

import java.util.Date;

public class PhotoInfo {

    private Integer id;


    private String photoName;


    private String photoDesc;


    private String photoUrl;


    private Integer createUserId;


    private String exifCamera;


    private String exifAperture;


    private String exifFacus;


    private String exifShutter;


    private String exifIso;


    private String exifOther;


    private Integer viewCount;


    private Integer likeCount;


    private Integer commentCount;


    private Date createTime;


    private Date updateTime;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getPhotoName() {
        return photoName;
    }


    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }


    public String getPhotoDesc() {
        return photoDesc;
    }


    public void setPhotoDesc(String photoDesc) {
        this.photoDesc = photoDesc;
    }


    public String getPhotoUrl() {
        return photoUrl;
    }


    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }


    public Integer getCreateUserId() {
        return createUserId;
    }


    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }


    public String getExifCamera() {
        return exifCamera;
    }


    public void setExifCamera(String exifCamera) {
        this.exifCamera = exifCamera;
    }


    public String getExifAperture() {
        return exifAperture;
    }


    public void setExifAperture(String exifAperture) {
        this.exifAperture = exifAperture;
    }


    public String getExifFacus() {
        return exifFacus;
    }


    public void setExifFacus(String exifFacus) {
        this.exifFacus = exifFacus;
    }


    public String getExifShutter() {
        return exifShutter;
    }


    public void setExifShutter(String exifShutter) {
        this.exifShutter = exifShutter;
    }


    public String getExifIso() {
        return exifIso;
    }


    public void setExifIso(String exifIso) {
        this.exifIso = exifIso;
    }


    public String getExifOther() {
        return exifOther;
    }


    public void setExifOther(String exifOther) {
        this.exifOther = exifOther;
    }


    public Integer getViewCount() {
        return viewCount;
    }


    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }


    public Integer getLikeCount() {
        return likeCount;
    }


    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }


    public Integer getCommentCount() {
        return commentCount;
    }


    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
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
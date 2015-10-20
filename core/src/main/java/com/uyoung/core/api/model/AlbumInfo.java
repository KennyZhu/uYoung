package com.uyoung.core.api.model;

import java.util.Date;

public class AlbumInfo {

    private Integer id;

    private String title;

    private Integer createUserId;

    private String albumName;

    private String albumUrl;
    /**
     * 封面照片URL
     */
    private String firstPhotoUrl;
    /**
     * 照片点赞数和
     */
    private long totalLikeCount;

    /**
     * 总的照片数
     */
    private Integer totalPhotoCount;
    /**
     * 活动ID
     */
    private Integer activityId;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumUrl() {
        return albumUrl;
    }

    public void setAlbumUrl(String albumUrl) {
        this.albumUrl = albumUrl;
    }

    public String getFirstPhotoUrl() {
        return firstPhotoUrl;
    }

    public void setFirstPhotoUrl(String firstPhotoUrl) {
        this.firstPhotoUrl = firstPhotoUrl;
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

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public long getTotalLikeCount() {
        return totalLikeCount;
    }

    public void setTotalLikeCount(long totalLikeCount) {
        this.totalLikeCount = totalLikeCount;
    }

    public Integer getTotalPhotoCount() {
        return totalPhotoCount;
    }

    public void setTotalPhotoCount(Integer totalPhotoCount) {
        this.totalPhotoCount = totalPhotoCount;
    }
}
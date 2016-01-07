package com.uyoung.web.vo;

/**
 * Desc:活动相关相册
 * <p/>Date: 2016-01-07
 * <br/>Time: 17:46
 * <br/>User: ylzhu
 */
public class AlbumActivityVo {
    private Integer activityId;

    private Integer albumId;

    private String oriUrl;

    private String firstPhotoUrl;

    private int totalPhotoCount;

    private int totalViewCount;

    private long totalLikeCount;

    private String createTime;


    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFirstPhotoUrl() {
        return firstPhotoUrl;
    }

    public void setFirstPhotoUrl(String firstPhotoUrl) {
        this.firstPhotoUrl = firstPhotoUrl;
    }

    public String getOriUrl() {
        return oriUrl;
    }

    public void setOriUrl(String oriUrl) {
        this.oriUrl = oriUrl;
    }

    public long getTotalLikeCount() {
        return totalLikeCount;
    }

    public void setTotalLikeCount(long totalLikeCount) {
        this.totalLikeCount = totalLikeCount;
    }

    public int getTotalPhotoCount() {
        return totalPhotoCount;
    }

    public void setTotalPhotoCount(int totalPhotoCount) {
        this.totalPhotoCount = totalPhotoCount;
    }

    public int getTotalViewCount() {
        return totalViewCount;
    }

    public void setTotalViewCount(int totalViewCount) {
        this.totalViewCount = totalViewCount;
    }


    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }


    @Override
    public String toString() {
        return "AlbumActivityVo{" +
                "activityId=" + activityId +
                ", albumId=" + albumId +
                ", oriUrl='" + oriUrl + '\'' +
                ", firstPhotoUrl='" + firstPhotoUrl + '\'' +
                ", totalPhotoCount=" + totalPhotoCount +
                ", totalViewCount=" + totalViewCount +
                ", totalLikeCount=" + totalLikeCount +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}

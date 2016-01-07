package com.uyoung.web.vo;

/**
 * Desc:
 * <p/>Date: 2015-10-20
 * <br/>Time: 16:29
 * <br/>User: ylzhu
 */
public class AlbumInfoVo {
    private Integer id;
    private String albumName;
    private long totalLikeCount;
    private long totalPhotoCount;
    private String firstPhotoUrl;
    private String createTime;

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getTotalLikeCount() {
        return totalLikeCount;
    }

    public void setTotalLikeCount(Long totalLikeCount) {
        this.totalLikeCount = totalLikeCount;
    }

    public long getTotalPhotoCount() {
        return totalPhotoCount;
    }

    public void setTotalPhotoCount(long totalPhotoCount) {
        this.totalPhotoCount = totalPhotoCount;
    }
}

package com.uyoung.web.vo;

import com.uyoung.core.api.model.PhotoInfo;

import java.util.Date;
import java.util.List;

/**
 * User: KennyZhu
 * Date: 15/12/6
 * Desc:相册详情
 */
public class AlbumDetailVo {

    private Integer albumId;

    private Integer oriUserId;

    private String oriUrl;

    private String oriNickName;

    private Date createTime;

    private int photoNum;

    private List<PhotoInfo> photoInfoList;

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getOriUserId() {
        return oriUserId;
    }

    public void setOriUserId(Integer oriUserId) {
        this.oriUserId = oriUserId;
    }

    public String getOriUrl() {
        return oriUrl;
    }

    public void setOriUrl(String oriUrl) {
        this.oriUrl = oriUrl;
    }

    public String getOriNickName() {
        return oriNickName;
    }

    public void setOriNickName(String oriNickName) {
        this.oriNickName = oriNickName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getPhotoNum() {
        return photoNum;
    }

    public void setPhotoNum(int photoNum) {
        this.photoNum = photoNum;
    }

    public List<PhotoInfo> getPhotoInfoList() {
        return photoInfoList;
    }

    public void setPhotoInfoList(List<PhotoInfo> photoInfoList) {
        this.photoInfoList = photoInfoList;
    }
}

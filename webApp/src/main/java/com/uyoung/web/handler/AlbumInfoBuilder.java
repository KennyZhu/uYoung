package com.uyoung.web.handler;

import com.uyoung.core.api.model.AlbumInfo;
import com.uyoung.core.base.bean.Page;
import com.uyoung.web.vo.AlbumInfoVo;
import org.apache.commons.collections.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * <p/>Date: 2015-10-20
 * <br/>Time: 16:33
 * <br/>User: ylzhu
 */
public class AlbumInfoBuilder {
    private AlbumInfo albumInfo;
    private AlbumInfoVo albumInfoVo;

    private Page<AlbumInfo> albumInfoPage;
    private Page<AlbumInfoVo> albumInfoVoPage;

    public AlbumInfoBuilder(AlbumInfo albumInfo) {
        this.albumInfo = albumInfo;
        albumInfoVo = new AlbumInfoVo();
    }

    public AlbumInfoBuilder(Page<AlbumInfo> albumInfoPage) {
        this.albumInfoPage = albumInfoPage;
        albumInfoVoPage = new Page<>();
        albumInfoVoPage.setPageNum(albumInfoPage.getPageNum());
        albumInfoVoPage.setPageSize(albumInfoPage.getPageSize());
    }

    public AlbumInfoBuilder buildBaseInfo() {
        albumInfoVo = convert2Vo(this.albumInfo);
        return this;
    }

    /**
     * Build Page
     *
     * @return
     */
    public AlbumInfoBuilder builderAlbumInfoVoPage() {
        if (CollectionUtils.isNotEmpty(albumInfoPage.getDataList())) {
            return this;
        }
        List<AlbumInfoVo> albumInfoVos = new ArrayList<>(albumInfoPage.getDataList().size());
        for (AlbumInfo albumInfo : albumInfoPage.getDataList()) {
            albumInfoVos.add(convert2Vo(albumInfo));
        }
        albumInfoVoPage.setDataList(albumInfoVos);
        return this;
    }

    private AlbumInfoVo convert2Vo(AlbumInfo albumInfo) {
        AlbumInfoVo albumInfoVo = new AlbumInfoVo();
        albumInfoVo.setId(albumInfo.getId());
        albumInfoVo.setAlbumName(albumInfo.getAlbumName());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        albumInfoVo.setCreateTime(simpleDateFormat.format(albumInfo.getCreateTime()));
        albumInfoVo.setFirstPhotoUrl(albumInfo.getFirstPhotoUrl());
        albumInfoVo.setTotalLikeCount(albumInfo.getTotalLikeCount());
        albumInfoVo.setTotalPhotoCount(albumInfo.getTotalPhotoCount());
        return albumInfoVo;
    }

    public Page<AlbumInfoVo> getAlbumInfoVoPage() {
        return albumInfoVoPage;
    }

    public Page<AlbumInfo> getAlbumInfoPage() {
        return albumInfoPage;
    }

    public AlbumInfo getAlbumInfo() {
        return albumInfo;
    }

    public AlbumInfoVo getAlbumInfoVo() {
        return albumInfoVo;
    }
}

package com.uyoung.core.api.dao;

import com.uyoung.core.api.model.AlbumInfo;
import com.uyoung.core.base.bean.Page;

import java.util.List;

public interface AlbumInfoDao {

    int deleteById(Integer id);

    int insert(AlbumInfo record);

    AlbumInfo getById(Integer id);

    int updateById(AlbumInfo record);

    Page<AlbumInfo> getPageByCreateUserId(Integer cuid, Integer page, Integer pageSize);

    int incLikeCount(Integer id);

    int decLikeCount(Integer id);

    int updateFirstPhotoUrl(Integer id, String firstUrl);

    int updateTotalPhotoCount(Integer id, int totalCount);

    List<AlbumInfo> getAllAlbumCount();


}
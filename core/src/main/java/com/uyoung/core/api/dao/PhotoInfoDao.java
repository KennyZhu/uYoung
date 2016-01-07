package com.uyoung.core.api.dao;

import com.uyoung.core.api.model.PhotoInfo;

import java.util.List;

public interface PhotoInfoDao {

    int deleteById(Integer id);

    int insert(PhotoInfo record);

    PhotoInfo getById(Integer id);

    int getTotalCountByAlbumId(Integer albumId);

    int updateById(PhotoInfo record);

    int deleteByAlbumId(Integer albumId);

    List<PhotoInfo> getListByAlbumId(Integer albumId);

    int incLikeCount(Integer id);

    int decLikeCount(Integer id);

    int incViewCount(Integer id);
}
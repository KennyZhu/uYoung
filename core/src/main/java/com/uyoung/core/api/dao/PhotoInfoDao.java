package com.uyoung.core.api.dao;

import com.uyoung.core.api.model.PhotoInfo;

public interface PhotoInfoDao {

    int deleteById(Integer id);

    int insert(PhotoInfo record);

    PhotoInfo getById(Integer id);

    int updateById(PhotoInfo record);

    int deleteByAlbumId(Integer albumId);
}
package com.uyoung.core.api.dao;

import com.uyoung.core.api.model.AlbumInfo;

public interface AlbumInfoDao {

    int deleteByPrimaryKey(Integer id);

    int insert(AlbumInfo record);

    AlbumInfo selectByPrimaryKey(Integer id);

    int updateById(AlbumInfo record);
}
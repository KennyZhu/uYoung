package com.uyoung.core.api.dao;

import com.uyoung.core.api.model.AlbumInfo;
import com.uyoung.core.base.bean.Page;

public interface AlbumInfoDao {

    int deleteByPrimaryKey(Integer id);

    int insert(AlbumInfo record);

    AlbumInfo getById(Integer id);

    int updateById(AlbumInfo record);

    Page<AlbumInfo> getPageByCreateUserId(Integer cuid, Integer page, Integer pageSize);
}
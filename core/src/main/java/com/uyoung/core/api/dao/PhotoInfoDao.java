package com.uyoung.core.api.dao;

import com.uyoung.core.api.model.PhotoInfo;

public interface PhotoInfoDao {

    int deleteByPrimaryKey(Integer id);

    int insert(PhotoInfo record);

    PhotoInfo selectByPrimaryKey(Integer id);

    int updateById(PhotoInfo record);
}
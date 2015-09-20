package com.uyoung.core.api.dao;

import com.uyoung.core.api.model.PhotoLike;

public interface PhotoLikeDao {

    int deleteByPrimaryKey(Integer id);

    int insert(PhotoLike record);

    PhotoLike selectByPrimaryKey(Integer id);

    int updateById(PhotoLike record);
}
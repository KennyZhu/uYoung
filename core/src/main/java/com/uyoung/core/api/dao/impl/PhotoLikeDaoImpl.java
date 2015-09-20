package com.uyoung.core.api.dao.impl;

import com.uyoung.core.api.dao.PhotoLikeDao;
import com.uyoung.core.api.model.PhotoLike;
import org.springframework.stereotype.Repository;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Repository
public class PhotoLikeDaoImpl implements PhotoLikeDao {
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(PhotoLike record) {
        return 0;
    }

    @Override
    public PhotoLike getById(Integer id) {
        return null;
    }

    @Override
    public int updateById(PhotoLike record) {
        return 0;
    }
}

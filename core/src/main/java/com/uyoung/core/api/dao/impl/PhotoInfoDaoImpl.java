package com.uyoung.core.api.dao.impl;

import com.uyoung.core.api.dao.PhotoInfoDao;
import com.uyoung.core.api.model.PhotoInfo;
import org.springframework.stereotype.Repository;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Repository
public class PhotoInfoDaoImpl implements PhotoInfoDao {
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(PhotoInfo record) {
        return 0;
    }

    @Override
    public PhotoInfo getById(Integer id) {
        return null;
    }

    @Override
    public int updateById(PhotoInfo record) {
        return 0;
    }
}

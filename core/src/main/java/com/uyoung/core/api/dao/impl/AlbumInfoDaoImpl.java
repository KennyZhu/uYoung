package com.uyoung.core.api.dao.impl;

import com.uyoung.core.api.dao.AlbumInfoDao;
import com.uyoung.core.api.model.AlbumInfo;
import org.springframework.stereotype.Repository;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Repository
public class AlbumInfoDaoImpl implements AlbumInfoDao {
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(AlbumInfo record) {
        return 0;
    }

    @Override
    public AlbumInfo getById(Integer id) {
        return null;
    }

    @Override
    public int updateById(AlbumInfo record) {
        return 0;
    }
}

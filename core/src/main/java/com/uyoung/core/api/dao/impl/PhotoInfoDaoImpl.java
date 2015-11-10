package com.uyoung.core.api.dao.impl;

import com.uyoung.core.api.dao.PhotoInfoDao;
import com.uyoung.core.api.model.PhotoInfo;
import com.uyoung.core.base.dao.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Repository
public class PhotoInfoDaoImpl extends BaseDao<PhotoInfo> implements PhotoInfoDao {
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(PhotoInfo record) {
        return insert("insert", record);
    }

    @Override
    public PhotoInfo getById(Integer id) {
        return selectOne("getById", id);
    }

    @Override
    public int updateById(PhotoInfo record) {
        return 0;
    }
}

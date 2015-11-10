package com.uyoung.core.api.dao.impl;

import com.uyoung.core.api.dao.MobileInfoDao;
import com.uyoung.core.api.model.MobileInfo;
import com.uyoung.core.base.dao.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Repository
public class MobileInfoDaoImpl extends BaseDao<MobileInfo> implements MobileInfoDao {
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(MobileInfo record) {
        return insert("insert", record);
    }

    @Override
    public MobileInfo getById(Integer id) {
        return null;
    }

    @Override
    public int updateById(MobileInfo record) {
        return 0;
    }
}

package com.uyoung.core.api.dao.impl;

import com.uyoung.core.api.dao.ThirdUserInfoDao;
import com.uyoung.core.api.model.ThirdUserInfo;
import com.uyoung.core.base.dao.BaseDao;

/**
 * Desc:
 * <p/>Date: 2015-10-30
 * <br/>Time: 18:27
 * <br/>User: ylzhu
 */
public class ThirdUserInfoDaoImpl extends BaseDao<ThirdUserInfo> implements ThirdUserInfoDao {

    @Override
    public int insertSelective(ThirdUserInfo record) {
        return 0;
    }

    @Override
    public ThirdUserInfo selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(ThirdUserInfo record) {
        return 0;
    }
}

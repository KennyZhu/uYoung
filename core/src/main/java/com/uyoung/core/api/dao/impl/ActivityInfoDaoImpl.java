package com.uyoung.core.api.dao.impl;

import com.uyoung.core.api.dao.ActivityInfoDao;
import com.uyoung.core.api.model.ActivityInfo;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
public class ActivityInfoDaoImpl implements ActivityInfoDao {
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insertSelective(ActivityInfo record) {
        return 0;
    }

    @Override
    public ActivityInfo selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(ActivityInfo record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(ActivityInfo record) {
        return 0;
    }
}

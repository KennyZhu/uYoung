package com.uyoung.core.api.dao.impl;

import com.uyoung.core.api.dao.ActivityInfoDao;
import com.uyoung.core.api.model.ActivityInfo;
import org.springframework.stereotype.Repository;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Repository
public class ActivityInfoDaoImpl implements ActivityInfoDao {
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(ActivityInfo record) {
        return 0;
    }

    @Override
    public ActivityInfo selectByPrimaryKey(Integer id) {
        return null;
    }
    
    @Override
    public int updateById(ActivityInfo record) {
        return 0;
    }
}

package com.uyoung.core.api.dao;

import com.uyoung.core.api.model.MobileInfo;

public interface MobileInfoDao {

    int deleteByPrimaryKey(Integer id);

    int insert(MobileInfo record);

    MobileInfo selectByPrimaryKey(Integer id);

    int updateById(MobileInfo record);
}
package com.uyoung.core.api.dao;

import com.uyoung.core.api.model.MobileInfo;

public interface MobileInfoDao {

    int deleteByPrimaryKey(Integer id);

    int insert(MobileInfo record);

    MobileInfo getById(Integer id);

    int updateById(MobileInfo record);
}
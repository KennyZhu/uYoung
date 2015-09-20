package com.uyoung.core.api.dao;

import com.uyoung.core.api.model.ActivityInfo;

public interface ActivityInfoDao {


    int deleteByPrimaryKey(Integer id);


    int insert(ActivityInfo record);


    ActivityInfo selectByPrimaryKey(Integer id);


    int updateById(ActivityInfo record);
}
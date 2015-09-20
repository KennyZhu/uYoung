package com.uyoung.core.api.dao;

import com.uyoung.core.api.model.ActivityInfo;

public interface ActivityInfoDao {


    int deleteByPrimaryKey(Integer id);


    int insertSelective(ActivityInfo record);


    ActivityInfo selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(ActivityInfo record);


    int updateByPrimaryKey(ActivityInfo record);
}
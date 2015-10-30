package com.uyoung.core.api.dao;

import com.uyoung.core.api.model.ThirdUserInfo;

public interface ThirdUserInfoDao {

    int insertSelective(ThirdUserInfo record);

    ThirdUserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ThirdUserInfo record);

}
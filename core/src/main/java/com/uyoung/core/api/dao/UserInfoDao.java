package com.uyoung.core.api.dao;

import com.uyoung.core.api.model.UserInfo;

public interface UserInfoDao {

    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    UserInfo getById(Integer id);

    int updateById(UserInfo record);
}
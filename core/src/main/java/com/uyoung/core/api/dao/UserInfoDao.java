package com.uyoung.core.api.dao;

import com.uyoung.core.api.model.UserInfo;

import java.util.List;

public interface UserInfoDao {

    int insert(UserInfo record);

    UserInfo getById(Integer id);

    int updateById(UserInfo record);

    List<UserInfo> getAvatarListByUserIdList(List<Integer> userIds);

    UserInfo getByEmail(String email);

    UserInfo getByEmailPassword(String email, String password);
}
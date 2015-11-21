package com.uyoung.core.api.dao;

import com.uyoung.core.api.model.ActivitySignUp;

import java.util.List;

public interface ActivitySignUpDao {

    int deleteByPrimaryKey(Integer id);

    int insert(ActivitySignUp record);

    ActivitySignUp getById(Integer id);

    int updateById(ActivitySignUp record);

    int updateStatusByUidAid(Integer uid, Integer aid, int status);

    List<ActivitySignUp> getListByActivityId(Integer aid);
}
package com.uyoung.core.api.dao;

import com.uyoung.core.api.model.ActivitySignUp;

import java.util.Date;
import java.util.List;

public interface ActivitySignUpDao {

    int deleteByPrimaryKey(Integer id);

    int insert(ActivitySignUp record);

    ActivitySignUp getById(Integer id);

    int updateStatusByUidAid(Integer uid, Integer aid, int status);

    List<ActivitySignUp> getListByActivityId(Integer aid);

    List<ActivitySignUp> getListByUidBeginTime(Integer uid, Date beginTime);

    ActivitySignUp getByAidUid(Integer aid, Integer uid);
}
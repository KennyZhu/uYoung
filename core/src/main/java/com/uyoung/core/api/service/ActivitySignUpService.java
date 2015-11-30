package com.uyoung.core.api.service;

import com.uyoung.core.api.enums.ActivitySignUpStatusEnum;
import com.uyoung.core.api.model.ActivitySignUp;

import java.util.List;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
public interface ActivitySignUpService {

    public int add(ActivitySignUp activitySignUp);

    public int cancel(Integer aid, Integer uid);

    public ActivitySignUp getById(int id);

    public int updateById(ActivitySignUp activitySignUp);

    int updateStatusByUidAid(Integer uid, Integer aid, ActivitySignUpStatusEnum statusEnum);

    List<ActivitySignUp> getListByActivityId(Integer activityId);
}

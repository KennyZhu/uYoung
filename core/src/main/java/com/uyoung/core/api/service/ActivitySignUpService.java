package com.uyoung.core.api.service;

import com.uyoung.core.api.model.ActivitySignUp;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
public interface ActivitySignUpService {

    public int add(ActivitySignUp activitySignUp);

    public ActivitySignUp getById(int id);

    public int updateById(ActivitySignUp activitySignUp);
}

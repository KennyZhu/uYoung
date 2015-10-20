package com.uyoung.core.api.service.impl;

import com.uyoung.core.api.dao.ActivitySignUpDao;
import com.uyoung.core.api.model.ActivitySignUp;
import com.uyoung.core.api.service.ActivitySignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Service("activitySignUpService")
public class ActivitySignUpServiceImpl implements ActivitySignUpService {
    @Autowired
    private ActivitySignUpDao activitySignUpDao;

    @Override
    public int add(ActivitySignUp activitySignUp) {
        if (activitySignUp == null) {
            return 0;
        }
        return activitySignUpDao.insert(activitySignUp);
    }

    @Override
    public ActivitySignUp getById(int id) {
        return activitySignUpDao.getById(id);
    }

    @Override
    public int updateById(ActivitySignUp activitySignUp) {
        if (activitySignUp == null || activitySignUp.getId() == 0) {
            return 0;
        }
        return activitySignUpDao.updateById(activitySignUp);
    }

    @Override
    public List<ActivitySignUp> getListByActivityId(Integer activityId) {
        if (activityId == null) {
            return Collections.emptyList();
        }
        return activitySignUpDao.getListByActivityId(activityId);
    }
}

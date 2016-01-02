package com.uyoung.core.api.service.impl;

import com.uyoung.core.api.dao.ActivitySignUpDao;
import com.uyoung.core.api.enums.ActivitySignUpStatusEnum;
import com.uyoung.core.api.model.ActivitySignUp;
import com.uyoung.core.api.service.ActivitySignUpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Service("activitySignUpService")
public class ActivitySignUpServiceImpl implements ActivitySignUpService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActivitySignUpServiceImpl.class);
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
    public int updateStatusByUidAid(Integer uid, Integer aid, ActivitySignUpStatusEnum statusEnum) {
        if (uid == null || aid == null) {
            return 0;
        }
        return activitySignUpDao.updateStatusByUidAid(uid, aid, statusEnum.getStatus());
    }

    @Override
    public List<ActivitySignUp> getListByActivityId(Integer activityId) {
        if (activityId == null) {
            return Collections.emptyList();
        }
        return activitySignUpDao.getListByActivityId(activityId);
    }

    @Override
    public boolean cancel(Integer uid, Integer aid) {
        if (aid == null || uid == null) {
            LOGGER.error("Invalid param.");
            return false;
        }
        return activitySignUpDao.deleteByUidAid(uid, aid) == 1;
    }

    @Override
    public ActivitySignUp getByAidUid(Integer aid, Integer uid) {
        if (aid == null || uid == null) {
            return null;
        }
        return activitySignUpDao.getByAidUid(aid, uid);
    }

    @Override
    public List<ActivitySignUp> getListByUidBeginTime(Integer uid, Date beginTime) {
        if (uid == null || beginTime == null) {
            return Collections.emptyList();
        }
        return activitySignUpDao.getListByUidBeginTime(uid, beginTime);
    }
}

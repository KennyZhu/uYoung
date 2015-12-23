package com.uyoung.core.api.service.impl;

import com.uyoung.core.api.dao.ActivitySignUpDao;
import com.uyoung.core.api.enums.ActivitySignUpStatusEnum;
import com.uyoung.core.api.enums.ActivityStatusEnum;
import com.uyoung.core.api.model.ActivitySignUp;
import com.uyoung.core.api.service.ActivitySignUpService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public int cancel(Integer aid, Integer uid) {
        if (aid == null || uid == null) {
            return 0;
        }
        return activitySignUpDao.updateStatusByUidAid(uid, aid, ActivitySignUpStatusEnum.CANCEL.getStatus());
    }

    @Override
    public int updateActivityStatusByAid(Integer aid, ActivityStatusEnum activityStatusEnum) {
        if (aid == null || activityStatusEnum == null) {
            return 0;
        }
        return activitySignUpDao.updateActivityStatusByAid(aid, activityStatusEnum.getStatus());
    }

    @Override
    public List<ActivitySignUp> getListByUidActivityStatusList(Integer uid, List<ActivityStatusEnum> activityStatusEnums) {
        if (uid == null || CollectionUtils.isEmpty(activityStatusEnums)) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> statusList = new ArrayList<>();
        for (ActivityStatusEnum statusEnum : activityStatusEnums) {
            statusList.add(statusEnum.getStatus());
        }
        return activitySignUpDao.getListByUidActivityStatusList(uid, statusList);
    }

    @Override
    public ActivitySignUp getByAidUid(Integer aid, Integer uid) {
        if (aid == null || uid == null) {
            return null;
        }
        return activitySignUpDao.getByAidUid(aid, uid);
    }
}

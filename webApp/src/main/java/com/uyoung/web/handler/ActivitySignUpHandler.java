package com.uyoung.web.handler;

import com.uyoung.core.api.enums.ActivityStatusEnum;
import com.uyoung.core.api.exception.BusinessException;
import com.uyoung.core.api.model.ActivityInfo;
import com.uyoung.core.api.model.ActivitySignUp;
import com.uyoung.core.api.service.ActivityInfoService;
import com.uyoung.core.api.service.ActivitySignUpService;
import com.uyoung.web.enums.ResultCodeEnum;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * <p/>Date: 2015-12-07
 * <br/>Time: 18:18
 * <br/>User: ylzhu
 */
@Service
public class ActivitySignUpHandler {

    @Autowired
    private ActivitySignUpService signUpService;

    @Autowired
    private ActivityInfoService activityInfoService;

    /**
     * 报名
     *
     * @param activitySignUp
     * @return
     */
    public boolean signUp(ActivitySignUp activitySignUp) throws Exception {
        if (activitySignUp == null || activitySignUp.getActivityId() == null || activitySignUp.getUserId() == null) {
            return false;
        }
        Integer activityId = activitySignUp.getActivityId();
        ActivityInfo activityInfo = activityInfoService.getById(activityId);
        if (activityInfo == null) {
            throw new BusinessException(ResultCodeEnum.ACTIVITY_NOT_EXIST);
        }
        ActivityStatusEnum statusEnum = ActivityStatusEnum.getByStatus(activityInfo.getStatus());
        switch (statusEnum) {
            case ACTIVE:
                throw new BusinessException(ResultCodeEnum.ACTIVITY_STARTED);
            case CANCEL:
                throw new BusinessException(ResultCodeEnum.ACTIVITY_CANCEL);
            case COMPLETE:
                throw new BusinessException(ResultCodeEnum.ACTIVITY_COMPLETED);
        }

        ArrayList<ActivityStatusEnum> activityStatusEnums = new ArrayList<>();
        activityStatusEnums.add(ActivityStatusEnum.ACTIVE);
        activityStatusEnums.add(ActivityStatusEnum.SIGNUP);
        List<ActivitySignUp> alreadySignActs = signUpService.getListByUidActivityStatusList(activitySignUp.getUserId(), activityStatusEnums);
        if (CollectionUtils.isNotEmpty(alreadySignActs)) {
            List<Integer> activityIdList = new ArrayList<>();
            for (ActivitySignUp signUp : alreadySignActs) {
                activityIdList.add(signUp.getActivityId());
            }
            List<ActivityInfo> activityInfos = activityInfoService.getListByIdList(activityIdList);
            for (ActivityInfo activity : activityInfos) {
                if (activityInfo.getBeginTime().after(activity.getBeginTime()) && activityInfo.getBeginTime().before(activity.getEndTime())) {
                    return false;
                }
                if (activity.getBeginTime().after(activity.getBeginTime()) && activity.getBeginTime().before(activityInfo.getEndTime())) {
                    return false;
                }
            }
        }
        int result = signUpService.add(activitySignUp);
        return result == 1;
    }
}

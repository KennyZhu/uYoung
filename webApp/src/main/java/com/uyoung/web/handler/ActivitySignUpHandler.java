package com.uyoung.web.handler;

import com.uyoung.core.api.constant.CommonConstant;
import com.uyoung.core.api.enums.ActivityStatusEnum;
import com.uyoung.core.api.exception.BusinessException;
import com.uyoung.core.api.model.ActivityInfo;
import com.uyoung.core.api.model.ActivitySignUp;
import com.uyoung.core.api.service.ActivityInfoService;
import com.uyoung.core.api.service.ActivitySignUpService;
import com.uyoung.web.enums.ResultCodeEnum;
import com.uyoung.web.util.DateUtil;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivitySignUpHandler.class);
    @Autowired
    private ActivitySignUpService signUpService;

    @Autowired
    private ActivityInfoService activityInfoService;

    /**
     * 报名
     *
     * @return
     */
    public boolean signUp(Integer uid, Integer activityId) throws Exception {
        if (activityId == null || uid == null) {
            LOGGER.error("#Invalid param.");
            throw new BusinessException("Invalid param.");
        }
        ActivityInfo activityInfo = activityInfoService.getById(activityId);
        if (activityInfo == null) {
            LOGGER.error("#Get activityInfo by activityId return null.");
            throw new BusinessException(ResultCodeEnum.ACTIVITY_NOT_EXIST);
        }
        ActivityStatusEnum statusEnum = ActivityStatusEnum.getByStatus(activityInfo.getStatus());
        if (ActivityStatusEnum.SIGNUP != statusEnum) {
            throw new BusinessException(ResultCodeEnum.ACTIVITY_NOT_SIGN_UP);
        }
        List<ActivitySignUp> alreadySignActs = signUpService.getListByUidBeginTime(uid, DateUtil.getDate(CommonConstant.MAX_ACTIVITY_SIGNUP_TIME + CommonConstant.MAX_ACTIVITY_TIME_INTERVAL));
        if (CollectionUtils.isNotEmpty(alreadySignActs)) {
            List<Integer> activityIdList = new ArrayList<>();
            for (ActivitySignUp signUp : alreadySignActs) {
                activityIdList.add(signUp.getActivityId());
            }
            List<ActivityInfo> activityInfos = activityInfoService.getListByIdList(activityIdList);
            if (CollectionUtils.isNotEmpty(activityInfos)) {
                LOGGER.info("#Signed activity size is :" + activityInfos.size());
                for (ActivityInfo activity : activityInfos) {
                    if (activityInfo.getBeginTime().after(activity.getBeginTime()) && activityInfo.getBeginTime().before(activity.getEndTime())) {
                        LOGGER.error("#ActivituInfo :" + activityInfo.toString() + " Activity:" + activity.toString());
                        return false;
                    }
                    if (activity.getBeginTime().after(activity.getBeginTime()) && activity.getBeginTime().before(activityInfo.getEndTime())) {
                        LOGGER.error("#ActivituInfo :" + activityInfo.toString() + " Activity:" + activity.toString());
                        return false;
                    }
                }
            }
        }
        ActivitySignUp activitySignUp = new ActivitySignUp();
        activitySignUp.setActivityId(activityId);
        activitySignUp.setUserId(uid);
        activitySignUp.setActivityStatus(activityInfo.getStatus());
        int result = signUpService.add(activitySignUp);
        return result == 1;
    }
}

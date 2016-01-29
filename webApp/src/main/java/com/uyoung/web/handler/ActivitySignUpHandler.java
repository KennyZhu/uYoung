package com.uyoung.web.handler;

import com.uyoung.core.api.constant.CommonConstant;
import com.uyoung.core.api.enums.ActivityStatusEnum;
import com.uyoung.core.api.exception.BusinessException;
import com.uyoung.core.api.model.ActivityInfo;
import com.uyoung.core.api.model.ActivitySignUp;
import com.uyoung.core.api.service.ActivityInfoService;
import com.uyoung.core.api.service.ActivitySignUpService;
import com.uyoung.core.base.bean.Page;
import com.uyoung.web.enums.ResultCodeEnum;
import com.uyoung.web.util.DateUtil;
import com.uyoung.web.vo.ActivityInfoVo;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private ActivityInfoHandler infoHandler;


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

    /**
     * 获取我报名的活动列表
     *
     * @param uid
     * @param page
     * @param pageSize
     * @return
     */
    public Page<ActivityInfoVo> getMySignUpActInfos(Integer uid, int page, int pageSize) {
        Page<ActivityInfoVo> result = new Page<>();
        result.setPageSize(pageSize);
        result.setPageNum(page);
        Page<ActivitySignUp> signUpPage = signUpService.getPageByUid(uid, page, pageSize);
        if (signUpPage == null || CollectionUtils.isEmpty(signUpPage.getDataList())) {
            return result;
        }
        List<ActivitySignUp> dataList = signUpPage.getDataList();
        List<Integer> activityIdList = new ArrayList<>(dataList.size());

        for (ActivitySignUp signUp : dataList) {
            activityIdList.add(signUp.getActivityId());
        }

        List<ActivityInfo> activityInfos = activityInfoService.getListByIdList(activityIdList);
        if (CollectionUtils.isEmpty(activityInfos)) {
            return result;
        }
        Map<Integer, ActivityInfoVo> activityInfoVoMap = infoHandler.convertToVoMap(activityInfos);
        List<ActivityInfoVo> resultData = new ArrayList<>(dataList.size());
        dataList.stream().forEach(signData -> {
            resultData.add(activityInfoVoMap.get(signData.getActivityId()));
        });
        result.setDataList(resultData);
        return result;
    }
}

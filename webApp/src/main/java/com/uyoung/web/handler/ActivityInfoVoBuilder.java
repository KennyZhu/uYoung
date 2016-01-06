package com.uyoung.web.handler;

import com.uyoung.core.api.constant.CommonConstant;
import com.uyoung.core.api.enums.ActivityStatusEnum;
import com.uyoung.core.api.enums.ActivityTypeEnum;
import com.uyoung.core.api.enums.WeekEnum;
import com.uyoung.core.api.model.ActivityInfo;
import com.uyoung.core.api.model.UserInfo;
import com.uyoung.core.api.service.UserInfoService;
import com.uyoung.core.base.util.SpringContextHolder;
import com.uyoung.web.util.DateUtil;
import com.uyoung.web.vo.ActivityInfoVo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;

/**
 * Desc:
 * <p/>Date: 2015-10-16
 * <br/>Time: 14:15
 * <br/>User: ylzhu
 */
public class ActivityInfoVoBuilder {
    private ActivityInfoVo infoVo;
    private ActivityInfo activityInfo;

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityInfoVoBuilder.class);


    public ActivityInfoVoBuilder(ActivityInfo activityInfo) {
        this.infoVo = new ActivityInfoVo();
        this.activityInfo = activityInfo;

    }

    public ActivityInfoVoBuilder buildBase() {
        infoVo.setFeeType(activityInfo.getFeeType());
        infoVo.setAddress(activityInfo.getAddress());
        infoVo.setOriUserId(activityInfo.getOriUserId());
        infoVo.setId(activityInfo.getId());
        infoVo.setTitle(activityInfo.getTitle());
        infoVo.setNeedNum(activityInfo.getNeedNum());
        infoVo.setLocal(activityInfo.getAddress());
        infoVo.setStatus(activityInfo.getStatus());
        ActivityTypeEnum activityTypeEnum = ActivityTypeEnum.getByType(activityInfo.getActivityType());
        if (activityTypeEnum != null) {
            infoVo.setActivityTypeDesc(activityTypeEnum.getDesc());
        } else {
            LOGGER.warn("#Can not found activity type:", activityInfo.getActivityType());
        }
        ActivityStatusEnum statusEnum = ActivityStatusEnum.getByStatus(activityInfo.getStatus());
        if (statusEnum != null) {
            infoVo.setStatusDesc(statusEnum.getDesc());
        } else {
            LOGGER.warn("#Can not found activity status:", activityInfo.getStatus());
        }

        infoVo.setDay(DateUtil.getDay(activityInfo.getBeginTime()));
        infoVo.setMon(DateUtil.getMonth(activityInfo.getBeginTime()));
        WeekEnum weekEnum = WeekEnum.getByWeek(DateUtil.getWeek(activityInfo.getBeginTime()));
        if (weekEnum != null) {
            infoVo.setWeekDesc(weekEnum.getWeekCnDesc());
        } else {
            LOGGER.warn("#Can not found week :", activityInfo.getBeginTime());
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        infoVo.setFromTime(simpleDateFormat.format(activityInfo.getBeginTime()));
        infoVo.setToTime(simpleDateFormat.format(activityInfo.getEndTime()));
        return this;
    }

    public ActivityInfoVoBuilder buildDetail() {
        infoVo.setDescription(activityInfo.getDescription());
        infoVo.setRealNum(activityInfo.getRealNum());
        return this;
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    public ActivityInfoVoBuilder buildOriUserInfo() {
        UserInfoService userInfoService = SpringContextHolder.getBean("userInfoService");
        UserInfo userInfo = userInfoService.getById(activityInfo.getOriUserId());
        infoVo.setOriUserAvatarUrl(CommonConstant.DEFAULT_AVATAR_URL);
        if (userInfo != null && StringUtils.isNotBlank(userInfo.getAvatarUrl())) {
            infoVo.setOriUserAvatarUrl(userInfo.getAvatarUrl());
            infoVo.setOriUserNickName(userInfo.getNickName());
        }
        return this;
    }

    public ActivityInfo getActivityInfo() {
        return activityInfo;
    }

    public ActivityInfoVo getInfoVo() {
        return infoVo;
    }
}

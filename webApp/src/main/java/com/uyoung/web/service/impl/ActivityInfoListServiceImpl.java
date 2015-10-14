package com.uyoung.web.service.impl;

import com.uyoung.core.api.constant.CommonConstant;
import com.uyoung.core.api.enums.ActivityStatusEnum;
import com.uyoung.core.api.enums.ActivityTypeEnum;
import com.uyoung.core.api.enums.FeeTypeEnum;
import com.uyoung.core.api.enums.WeekEnum;
import com.uyoung.core.api.model.ActivityInfo;
import com.uyoung.core.api.model.UserInfo;
import com.uyoung.core.api.service.ActivityInfoService;
import com.uyoung.core.api.service.UserInfoService;
import com.uyoung.core.base.bean.Page;
import com.uyoung.web.service.ActivityInfoListService;
import com.uyoung.web.util.DataUtil;
import com.uyoung.web.vo.ActivityInfoVo;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: KennyZhu
 * Date: 15/10/12
 * Desc:
 */
@Service("activityInfoListService")
public class ActivityInfoListServiceImpl implements ActivityInfoListService {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ActivityInfoListService.class);
    @Autowired
    private ActivityInfoService activityInfoService;

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public Page<ActivityInfoVo> getPageByStatus(int page, int pageSize, ActivityStatusEnum statusEnum) {
        Page<ActivityInfo> activityInfoPage = activityInfoService.getPageByStatus(page, pageSize, statusEnum);
        if (activityInfoPage == null || CollectionUtils.isEmpty(activityInfoPage.getDataList())) {

        }
        List<ActivityInfo> activityInfoList = activityInfoPage.getDataList();
        List<ActivityInfoVo> activityInfoVos = new ArrayList<>(activityInfoList.size());
        List<Integer> oriUserIds = new ArrayList<>(activityInfoList.size());
        for (ActivityInfo activityInfo : activityInfoList) {
            oriUserIds.add(activityInfo.getOriUserId());
        }
        Map<Integer, UserInfo> userInfoMap = userInfoService.getAvatarMapByIdList(oriUserIds);
        for (ActivityInfo activityInfo : activityInfoList) {
            ActivityInfoVo infoVo = buildActivityInfoVo(activityInfo, userInfoMap);
            activityInfoVos.add(infoVo);
        }
        Page<ActivityInfoVo> result = new Page<>();
        result.setDataList(activityInfoVos);
        result.setPageSize(pageSize);
        result.setPageNum(page);
        return result;
    }

    private ActivityInfoVo buildActivityInfoVo(ActivityInfo activityInfo, Map<Integer, UserInfo> userInfoMap) {
        ActivityInfoVo infoVo = new ActivityInfoVo();

        FeeTypeEnum feeTypeEnum = FeeTypeEnum.getByCode(activityInfo.getFeeType());
        if (feeTypeEnum != null) {
            infoVo.setFeeType(feeTypeEnum.getDesc());
        } else {
            LOGGER.warn("#Can not found fee type:", activityInfo.getFeeType());
        }

        infoVo.setAddress(activityInfo.getAddress());
        infoVo.setId(activityInfo.getId());
        infoVo.setTitle(activityInfo.getTitle());
        infoVo.setNeedNum(activityInfo.getNeedNum());
        infoVo.setLocal(activityInfo.getAddress());
        ActivityTypeEnum activityTypeEnum = ActivityTypeEnum.getByType(activityInfo.getActivityType());
        if (activityTypeEnum != null) {
            infoVo.setActivityType(activityTypeEnum.getDesc());
        } else {
            LOGGER.warn("#Can not found activity type:", activityInfo.getActivityType());
        }
        ActivityStatusEnum statusEnum = ActivityStatusEnum.getByStatus(activityInfo.getStatus());
        if (statusEnum != null) {
            infoVo.setStatus(statusEnum.getDesc());
        } else {
            LOGGER.warn("#Can not found activity status:", activityInfo.getStatus());
        }

        infoVo.setDay(DataUtil.getDay(activityInfo.getBeginTime()));
        infoVo.setMon(DataUtil.getMonth(activityInfo.getBeginTime()));
        WeekEnum weekEnum = WeekEnum.getByWeek(DataUtil.getWeek(activityInfo.getBeginTime()));
        if (weekEnum != null) {
            infoVo.setWeekDesc(weekEnum.getWeekCnDesc());
        } else {
            LOGGER.warn("#Can not found week :", activityInfo.getBeginTime());
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");
        infoVo.setFromTime(simpleDateFormat.format(activityInfo.getBeginTime()));
        infoVo.setToTime(simpleDateFormat.format(activityInfo.getEndTime()));

        infoVo.setOriUserAvatarUrl(CommonConstant.DEFAULT_AVATAR_URL);
        if (userInfoMap.get(activityInfo.getId()) != null) {
            infoVo.setOriUserAvatarUrl(userInfoMap.get(activityInfo.getId()).getAvatarUrl());
        }
        return infoVo;
    }
}

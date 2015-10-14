package com.uyoung.web.service.impl;

import com.uyoung.core.api.constant.CommonConstant;
import com.uyoung.core.api.enums.ActivityStatusEnum;
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

        infoVo.setFeeType(activityInfo.getFeeType());
        infoVo.setActivityType(activityInfo.getActivityType());
        infoVo.setAddress(activityInfo.getAddress());
        infoVo.setId(activityInfo.getId());
        infoVo.setTitle(activityInfo.getTitle());
        infoVo.setNeedNum(activityInfo.getNeedNum());
        infoVo.setStatus(ActivityStatusEnum.getByStatus(activityInfo.getStatus()).getDesc());

        infoVo.setDay(DataUtil.getDay(activityInfo.getBeginTime()));
        infoVo.setMon(DataUtil.getMonth(activityInfo.getBeginTime()));
        infoVo.setWeekDesc(WeekEnum.getByWeek(DataUtil.getWeek(activityInfo.getBeginTime())).getWeekCnDesc());

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

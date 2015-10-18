package com.uyoung.web.handler;

import com.uyoung.core.api.enums.ActivityStatusEnum;
import com.uyoung.core.api.model.ActivityInfo;
import com.uyoung.core.api.model.UserInfo;
import com.uyoung.core.api.service.ActivityInfoService;
import com.uyoung.core.api.service.UserInfoService;
import com.uyoung.core.base.bean.Page;
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
 * User: KennyZhu
 * Date: 15/10/12
 * Desc:
 */
@Service("activityInfoHandler")
public class ActivityInfoHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityInfoHandler.class);
    @Autowired
    private ActivityInfoService activityInfoService;

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 批量获取活动信息
     *
     * @param page
     * @param pageSize
     * @param statusEnum
     * @param uid
     * @return
     */
    public Page<ActivityInfoVo> getPageByStatus(int page, int pageSize, ActivityStatusEnum statusEnum, Integer uid) {
        Page<ActivityInfoVo> result = new Page<>();
        result.setPageSize(pageSize);
        result.setPageNum(page);
        Page<ActivityInfo> activityInfoPage = activityInfoService.getPageByStatus(page, pageSize, statusEnum, uid);
        if (activityInfoPage == null || CollectionUtils.isEmpty(activityInfoPage.getDataList())) {
            return result;
        }
        List<ActivityInfo> activityInfoList = activityInfoPage.getDataList();
        List<ActivityInfoVo> activityInfoVos = new ArrayList<>(activityInfoList.size());
        List<Integer> oriUserIds = new ArrayList<>(activityInfoList.size());
        for (ActivityInfo activityInfo : activityInfoList) {
            oriUserIds.add(activityInfo.getOriUserId());
        }
        Map<Integer, UserInfo> userInfoMap = userInfoService.getAvatarMapByIdList(oriUserIds);
        for (ActivityInfo activityInfo : activityInfoList) {
            ActivityInfoVo infoVo = new ActivityInfoVoBuilder(activityInfo).buildBase().getInfoVo();
            buildAvatarUrl(infoVo, userInfoMap);
            activityInfoVos.add(infoVo);
        }

        result.setDataList(activityInfoVos);
        return result;
    }

    private void buildAvatarUrl(ActivityInfoVo activityInfoVo, Map<Integer, UserInfo> userInfoMap) {
        if (userInfoMap.get(activityInfoVo.getOriUserId()) != null) {
            activityInfoVo.setOriUserAvatarUrl(userInfoMap.get(activityInfoVo.getOriUserId()).getAvatarUrl());
        } else {
            LOGGER.warn("#Can not found userInfo by userId:" + activityInfoVo.getOriUserId());
        }
    }

    public ActivityInfoVo getActivityInfoById(int id) {
        ActivityInfo info = activityInfoService.getById(id);
        if (info == null) {
            return null;
        }
        return new ActivityInfoVoBuilder(info).buildBase().buildDetail().buildOriUserInfo().getInfoVo();
    }
}

package com.uyoung.web.service.impl;

import com.uyoung.core.api.enums.ActivityStatusEnum;
import com.uyoung.core.api.model.ActivityInfo;
import com.uyoung.core.api.model.UserInfo;
import com.uyoung.core.api.service.ActivityInfoService;
import com.uyoung.core.api.service.UserInfoService;
import com.uyoung.core.base.bean.Page;
import com.uyoung.web.service.ActivityInfoListService;
import com.uyoung.web.vo.ActivityInfoVo;
import org.apache.commons.collections.CollectionUtils;
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
@Service("activityInfoListService")
public class ActivityInfoListServiceImpl implements ActivityInfoListService {

    @Autowired
    private ActivityInfoService activityInfoService;

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public Page<ActivityInfoVo> getPageByStatus(ActivityStatusEnum statusEnum, int page, int pageSize) {
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
        for(ActivityInfo activityInfo:activityInfoList){


        }

        return null;
    }
}

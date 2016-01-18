package com.uyoung.core.api.service.impl;

import com.uyoung.core.api.anno.parse.SortParser;
import com.uyoung.core.api.bean.ActivityConditionBean;
import com.uyoung.core.api.dao.ActivityInfoDao;
import com.uyoung.core.api.enums.ActivityStatusEnum;
import com.uyoung.core.api.model.ActivityInfo;
import com.uyoung.core.api.service.ActivityInfoService;
import com.uyoung.core.base.bean.Page;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Service("activityInfoService")
public class ActivityInfoServiceImpl implements ActivityInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityInfoServiceImpl.class);
    @Autowired
    private ActivityInfoDao activityInfoDao;


    @Override
    public Page<ActivityInfo> getPageByStatus(int pageNum, int pageSize, ActivityStatusEnum statusEnum, Integer oriUid) {
        if (statusEnum == null) {
            return buildEmptyPage(pageNum, pageSize);
        }
        int offset = pageSize * (pageNum - 1) + 1;
        return activityInfoDao.getPageByStatus(offset, pageSize, statusEnum.getStatus(), oriUid);
    }

    private Page<ActivityInfo> buildEmptyPage(int pageNum, int pageSize) {
        Page<ActivityInfo> result = new Page<>();
        result.setPageNum(pageNum);
        result.setPageSize(pageSize);
        return result;
    }

    @Override
    public Page<ActivityInfo> getPageByCondition(ActivityConditionBean conditionBean, int pageNum, int pageSize) {
        if (conditionBean == null) {
            conditionBean = new ActivityConditionBean();
        }
        conditionBean.setSortColumn(SortParser.parser(conditionBean));
        int offset = pageSize * (pageNum - 1) + 1;
        return activityInfoDao.getPageByCondition(conditionBean, offset, pageSize);
    }

    @Override
    public int add(ActivityInfo activityInfo) {
        if (activityInfo == null) {
            return 0;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {

            if (StringUtils.isNotBlank(activityInfo.getStrBeginTime())) {
                activityInfo.setBeginTime(simpleDateFormat.parse(activityInfo.getStrBeginTime()));
            }
            if (StringUtils.isNotBlank(activityInfo.getStrEndTime())) {
                activityInfo.setEndTime(simpleDateFormat.parse(activityInfo.getStrEndTime()));
            }
            activityInfo.setStatus(ActivityStatusEnum.ACTIVE.getStatus());
        } catch (Exception e) {

        }
        return activityInfoDao.insert(activityInfo);
    }

    @Override
    public int deleteById(Integer activityId) {
        if (activityId == null) {
            return 0;
        }
        return activityInfoDao.deleteById(activityId);
    }

    @Override
    public ActivityInfo getById(int id) {
        return activityInfoDao.getById(id);
    }

    @Override
    public int updateById(ActivityInfo activityInfo) {
        if (activityInfo == null || activityInfo.getId() == null) {
            return 0;
        }
        return activityInfoDao.updateById(activityInfo);
    }

    @Override
    public int updateStatusById(Integer activityId, ActivityStatusEnum activityStatusEnum) {
        if (activityId == null || activityStatusEnum == null) {
            return 0;
        }
        return activityInfoDao.updateByIdStatus(activityId, activityStatusEnum.getStatus());
    }

    @Override
    public int cancel(Integer uid, Integer activityId) {
        if (uid == null || activityId == null) {
            return 0;
        }
        ActivityInfo activityInfo = activityInfoDao.getById(activityId);
        if (activityInfo == null) {
            LOGGER.error("#Can not found activityInfo.ActivityId is " + activityId);
            return 0;
        }
        if (!activityInfo.getOriUserId().equals(uid)) {
            LOGGER.error("#Activity :" + activityId + " is not User:" + uid);
            return 0;
        }
        return updateStatusById(activityId, ActivityStatusEnum.CANCEL);
    }

    @Override
    public List<ActivityInfo> getListByIdList(List<Integer> idList) {
        if (CollectionUtils.isEmpty(idList)) {
            return Collections.emptyList();
        }
        return activityInfoDao.getListByIdList(idList);
    }
}

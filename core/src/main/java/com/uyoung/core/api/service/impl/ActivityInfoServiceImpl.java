package com.uyoung.core.api.service.impl;

import com.uyoung.core.api.dao.ActivityInfoDao;
import com.uyoung.core.api.enums.ActivityStatusEnum;
import com.uyoung.core.api.model.ActivityInfo;
import com.uyoung.core.api.service.ActivityInfoService;
import com.uyoung.core.base.bean.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Service("activityInfoService")
public class ActivityInfoServiceImpl implements ActivityInfoService {
    @Autowired
    private ActivityInfoDao activityInfoDao;


    @Override
    public Page<ActivityInfo> getPageByStatus(int pageNum, int pageSize, ActivityStatusEnum statusEnum, Integer oriUid) {
        if (statusEnum == null) {
            Page<ActivityInfo> result = new Page<>();
            result.setPageNum(pageNum);
            result.setPageSize(pageSize);
            return result;
        }
        int offset = pageSize * (pageNum - 1) + 1;
        return activityInfoDao.getPageByStatus(offset, pageSize, statusEnum.getStatus(), oriUid);
    }


    @Override
    public int add(ActivityInfo activityInfo) {
        if (activityInfo == null) {
            return 0;
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
}

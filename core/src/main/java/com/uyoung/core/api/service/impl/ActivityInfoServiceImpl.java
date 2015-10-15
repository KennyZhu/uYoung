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
    public Page<ActivityInfo> getPageByStatus(int pageNum, int pageSize, ActivityStatusEnum statusEnum) {
        if (statusEnum == null) {
            return new Page<>();
        }
        int offset = pageSize * (pageNum - 1) + 1;
        return activityInfoDao.getPageByStatus(offset, pageSize, statusEnum.getStatus());
    }


    @Override
    public int add(ActivityInfo activityInfo) {
        if (activityInfo == null) {
            return 0;
        }
        return activityInfoDao.insert(activityInfo);
    }

    @Override
    public ActivityInfo getById(int id) {
        return activityInfoDao.getById(id);
    }

    @Override
    public int updateById(ActivityInfo activityInfo) {
        return activityInfoDao.updateById(activityInfo);
    }
}

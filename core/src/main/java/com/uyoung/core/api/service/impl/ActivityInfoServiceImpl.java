package com.uyoung.core.api.service.impl;

import com.uyoung.core.api.dao.ActivityInfoDao;
import com.uyoung.core.api.model.ActivityInfo;
import com.uyoung.core.api.service.ActivityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Service
public class ActivityInfoServiceImpl implements ActivityInfoService {


    @Autowired
    private ActivityInfoDao activityInfoDao;

    @Override
    public int add(ActivityInfo activityInfo) {
        if (activityInfo == null) {
            return 0;
        }
        return activityInfoDao.insert(activityInfo);
    }

    @Override
    public int updateById(ActivityInfo activityInfo) {
        return activityInfoDao.updateById(activityInfo);
    }
}

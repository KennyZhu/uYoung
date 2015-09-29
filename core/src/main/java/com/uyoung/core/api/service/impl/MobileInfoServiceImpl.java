package com.uyoung.core.api.service.impl;

import com.uyoung.core.api.dao.MobileInfoDao;
import com.uyoung.core.api.model.MobileInfo;
import com.uyoung.core.api.service.MobileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Service("mobileInfoService")
public class MobileInfoServiceImpl implements MobileInfoService {

    @Autowired
    private MobileInfoDao mobileInfoDao;

    public int add(MobileInfo mobileInfo) {
        if (mobileInfo == null) {
            return 0;
        }
        return mobileInfoDao.insert(mobileInfo);
    }

    @Override
    public MobileInfo getById(int id) {
        return mobileInfoDao.getById(id);
    }
}

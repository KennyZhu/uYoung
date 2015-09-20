package com.uyoung.core.api.service.impl;

import com.uyoung.core.api.dao.PhotoInfoDao;
import com.uyoung.core.api.model.PhotoInfo;
import com.uyoung.core.api.service.PhotoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Service
public class PhotoInfoServiceImpl implements PhotoInfoService {

    @Autowired
    private PhotoInfoDao photoInfoDao;

    @Override
    public int add(PhotoInfo photoInfo) {
        if (photoInfo == null) {
            return 0;
        }
        return photoInfoDao.insert(photoInfo);
    }

    @Override
    public PhotoInfo getById(int id) {
        return photoInfoDao.getById(id);
    }

    @Override
    public int updateById(PhotoInfo photoInfo) {
        if (photoInfo == null) {
            return 0;
        }
        return photoInfoDao.updateById(photoInfo);
    }
}

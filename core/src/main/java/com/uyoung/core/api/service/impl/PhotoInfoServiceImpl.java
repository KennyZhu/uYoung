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
@Service("photoInfoService")
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
    public PhotoInfo getById(Integer id) {
        if (id == null) {
            return null;
        }
        return photoInfoDao.getById(id);
    }

    @Override
    public int updateById(PhotoInfo photoInfo) {
        if (photoInfo == null) {
            return 0;
        }
        return photoInfoDao.updateById(photoInfo);
    }

    @Override
    public int deleteById(Integer id) {
        if (id == null) {
            return 0;
        }
        return photoInfoDao.deleteById(id);
    }

    @Override
    public int deleteByAlbumId(Integer albumId) {
        if (albumId == null) {
            return 0;
        }
        return photoInfoDao.deleteByAlbumId(albumId);
    }
}

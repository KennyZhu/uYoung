package com.uyoung.core.api.service.impl;

import com.uyoung.core.api.dao.PhotoInfoDao;
import com.uyoung.core.api.model.PhotoInfo;
import com.uyoung.core.api.service.PhotoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

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
    public int getTotalCountByAlbumId(Integer albumId) {
        if (albumId == null) {
            return 0;
        }
        return photoInfoDao.getTotalCountByAlbumId(albumId);

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
    public List<PhotoInfo> getListByAlbumId(Integer albumId) {
        if (albumId == null) {
            return Collections.EMPTY_LIST;
        }
        return photoInfoDao.getListByAlbumId(albumId);

    }

    @Override
    public int deleteByAlbumId(Integer albumId) {
        if (albumId == null) {
            return 0;
        }
        return photoInfoDao.deleteByAlbumId(albumId);
    }

    @Override
    public int incLikeCount(Integer photoId) {
        if (photoId == null) {
            return 0;
        }
        return photoInfoDao.incLikeCount(photoId);
    }

    @Override
    public boolean decLikeCount(Integer photoId) {
        if (photoId == null) {
            return false;
        }
        PhotoInfo photoInfo = photoInfoDao.getById(photoId);
        if (photoInfo != null && photoInfo.getLikeCount() > 0) {
            return photoInfoDao.decLikeCount(photoId) == 1;
        }
        return false;
    }

    @Override
    public boolean incViewCount(Integer photoId) {
        if (photoId == null) {
            return false;
        }
        return photoInfoDao.incViewCount(photoId) == 1;
    }
}

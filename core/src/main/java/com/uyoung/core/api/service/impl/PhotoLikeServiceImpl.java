package com.uyoung.core.api.service.impl;

import com.uyoung.core.api.dao.PhotoLikeDao;
import com.uyoung.core.api.model.PhotoLike;
import com.uyoung.core.api.service.PhotoLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Service("photoLikeService")
public class PhotoLikeServiceImpl implements PhotoLikeService {

    @Autowired
    private PhotoLikeDao photoLikeDao;

    @Override
    public boolean add(PhotoLike photoLike) {
        if (photoLike == null) {
            return false;
        }
        return photoLikeDao.insert(photoLike) == 1;
    }

    @Override
    public PhotoLike getById(int id) {
        return photoLikeDao.getById(id);
    }

    @Override
    public int getCountByPhotoId(int photoId) {
        return 0;
    }

    @Override
    public boolean delete(Integer uid, Integer photoId) {
        if (uid == null || photoId == null) {
            return false;
        }
        return photoLikeDao.deleteByUidPhotoId(uid, photoId) == 1;
    }

    @Override
    public PhotoLike getByUidPhotoId(Integer uid, Integer photoId) {
        if (uid == null || photoId == null) {
            return null;
        }
        return photoLikeDao.getByUidPhotoId(uid, photoId);
    }
}

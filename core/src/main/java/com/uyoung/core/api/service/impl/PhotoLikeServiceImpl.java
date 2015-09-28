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
@Service
public class PhotoLikeServiceImpl implements PhotoLikeService {

    @Autowired
    private PhotoLikeDao photoLikeDao;

    @Override
    public int add(PhotoLike photoLike) {
        if (photoLike == null) {
            return 0;
        }
        return photoLikeDao.insert(photoLike);
    }

    @Override
    public PhotoLike getById(int id) {
        return photoLikeDao.getById(id);
    }

    @Override
    public int getCountByPhotoId(int photoId) {
        return 0;
    }
}

package com.uyoung.core.api.service;

import com.uyoung.core.api.model.PhotoLike;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
public interface PhotoLikeService {

    public boolean add(PhotoLike photoLike);

    public boolean delete(Integer uid, Integer photoId);

    public PhotoLike getById(int id);

    public PhotoLike getByUidPhotoId(Integer uid, Integer photoId);

    int getCountByPhotoId(int photoId);
}

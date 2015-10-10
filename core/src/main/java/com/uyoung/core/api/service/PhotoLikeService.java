package com.uyoung.core.api.service;

import com.uyoung.core.api.model.PhotoLike;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
public interface PhotoLikeService {

    public int add(PhotoLike photoLike);

    public PhotoLike getById(int id);

    int getCountByPhotoId(int photoId);
}

package com.uyoung.web.handler;

import com.uyoung.core.api.model.PhotoLike;
import com.uyoung.core.api.service.PhotoLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Desc:
 * <p/>Date: 2015-11-10
 * <br/>Time: 16:30
 * <br/>User: ylzhu
 */
@Repository
public class PhotoLikeHandler {
    @Autowired
    private PhotoLikeService photoLikeService;

    /**
     * 照片点赞（并发问题）
     *
     * @param uid
     * @param photoId
     * @return
     */
    public boolean like(Integer uid, Integer photoId) {
        if (uid == null || photoId == null) {
            return false;
        }
        PhotoLike photoLike = photoLikeService.getByUidPhotoId(uid, photoId);
        if (photoLike == null) {
            photoLike = new PhotoLike();
            photoLike.setPhotoId(photoId);
            photoLike.setUserId(uid);
            photoLikeService.add(photoLike);
        } else {
            //TODO 更新喜欢数
            photoLikeService.delete(uid, photoId);
        }
        return true;
    }
}

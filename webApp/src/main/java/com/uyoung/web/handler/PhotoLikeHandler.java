package com.uyoung.web.handler;

import com.uyoung.core.api.model.PhotoInfo;
import com.uyoung.core.api.model.PhotoLike;
import com.uyoung.core.api.model.UserInfo;
import com.uyoung.core.api.service.PhotoInfoService;
import com.uyoung.core.api.service.PhotoLikeService;
import com.uyoung.core.api.service.UserInfoService;
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

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private PhotoInfoService photoInfoService;

    public boolean like(Integer uid, Integer photoId) {
        if (uid == null || photoId == null) {
            return false;
        }
        UserInfo userInfo = userInfoService.getById(uid);
        if (userInfo == null) {
            return false;
        }
        PhotoInfo photoInfo = photoInfoService.getById(photoId);
        if (photoInfo == null) {
            return false;
        }
        PhotoLike photoLike = new PhotoLike();
        photoLike.setPhotoId(photoId);
        photoLike.setUserId(uid);
        photoLikeService.add(photoLike);
        return true;
    }
}

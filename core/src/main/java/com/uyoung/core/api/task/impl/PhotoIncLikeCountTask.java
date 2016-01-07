package com.uyoung.core.api.task.impl;

import com.uyoung.core.api.model.PhotoInfo;

/**
 * Desc:照片点赞数处理
 * <p/>Date: 2015-12-25
 * <br/>Time: 11:11
 * <br/>User: ylzhu
 */
public class PhotoIncLikeCountTask extends AbsPhotoTask {

    public PhotoIncLikeCountTask(PhotoInfo photoInfo) {
        super(photoInfo);
    }

    @Override
    protected boolean exec() {
        LOGGER.info("#Begin to incLikeCount albumId is " + photoInfo.getAlbumId());
        return albumInfoService.incLikeCount(photoInfo.getAlbumId());
    }
}

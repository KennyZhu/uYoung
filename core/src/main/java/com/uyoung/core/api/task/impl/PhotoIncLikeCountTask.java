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
        return albumInfoService.incLikeCount(photoInfo.getAlbumId());
    }
}

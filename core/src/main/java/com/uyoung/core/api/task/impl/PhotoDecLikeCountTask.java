package com.uyoung.core.api.task.impl;

import com.uyoung.core.api.model.PhotoInfo;

/**
 * Desc:
 * <p/>Date: 2016-01-07
 * <br/>Time: 10:37
 * <br/>User: ylzhu
 */
public class PhotoDecLikeCountTask extends AbsPhotoTask {

    public PhotoDecLikeCountTask(PhotoInfo photoInfo) {
        super(photoInfo);
    }

    @Override
    public boolean exec() {

        return albumInfoService.decLikeCount(photoInfo.getAlbumId());
    }
}

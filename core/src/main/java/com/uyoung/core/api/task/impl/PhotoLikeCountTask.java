package com.uyoung.core.api.task.impl;

/**
 * Desc:照片点赞数处理
 * <p/>Date: 2015-12-25
 * <br/>Time: 11:11
 * <br/>User: ylzhu
 */
public class PhotoLikeCountTask extends AbsPhotoTask {

    public PhotoLikeCountTask(Integer photoId) {
        super(photoId);
    }

    @Override
    public Boolean call() throws Exception {
        return false;
    }
}

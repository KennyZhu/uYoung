package com.uyoung.core.api.task.impl;

import com.uyoung.core.api.model.PhotoInfo;
import com.uyoung.core.third.qiniu.QiNiuStoreFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Desc:照片删除处理
 * <p/>Date: 2015-12-24
 * <br/>Time: 12:07
 * <br/>User: ylzhu
 */
class PhotoDeleteTask extends AbsPhotoTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoDeleteTask.class);

    public PhotoDeleteTask(Integer photoId) {
        super(photoId);
    }

    @Override
    public Boolean call() throws Exception {
        try {
            return delFromQiNiu();
        } catch (Exception e) {
            LOGGER.error("#Execute photo delete error.id is " + photoId + " Cause:", e);
        }
        return false;
    }

    /**
     * 从七牛云删除
     *
     * @return
     */
    private boolean delFromQiNiu() {

        PhotoInfo photoInfo = getById();
        if (photoInfo != null) {
            return QiNiuStoreFactory.getInstance().del(photoInfo.getPhotoUrl());
        }
        return false;
    }
}

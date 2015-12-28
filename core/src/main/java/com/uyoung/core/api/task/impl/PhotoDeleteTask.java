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
public class PhotoDeleteTask extends AbsPhotoTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoDeleteTask.class);

    private PhotoInfo photoInfo;

    public PhotoDeleteTask(PhotoInfo photoInfo) {
        this.photoInfo = photoInfo;
    }

    @Override
    public Boolean call() throws Exception {
        try {
            return delFromQiNiu();

        } catch (Exception e) {
            LOGGER.error("#Execute photo delete error.Key is " + photoInfo.getPhotoUrl() + " Cause:", e);
        }
        return false;
    }

    /**
     * 从七牛云删除
     *
     * @return
     */
    private boolean delFromQiNiu() {
        LOGGER.info("#Begin to del photo from qiniu Key is " + photoInfo);
        return QiNiuStoreFactory.getInstance().del(photoInfo.getPhotoUrl());
    }
}

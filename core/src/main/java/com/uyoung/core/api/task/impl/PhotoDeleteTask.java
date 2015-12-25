package com.uyoung.core.api.task.impl;

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

    private String photoKey;

    public PhotoDeleteTask(String photoKey) {
        this.photoKey = photoKey;
    }

    @Override

    public Boolean call() throws Exception {
        try {
            return delFromQiNiu();
        } catch (Exception e) {
            LOGGER.error("#Execute photo delete error.Key is " + photoKey + " Cause:", e);
        }
        return false;
    }

    /**
     * 从七牛云删除
     *
     * @return
     */
    private boolean delFromQiNiu() {
        LOGGER.info("#Begin to del photo from qiniu Key is " + photoKey);
        return QiNiuStoreFactory.getInstance().del(photoKey);
    }
}

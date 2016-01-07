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


    public PhotoDeleteTask(PhotoInfo photoInfo) {
        super(photoInfo);
    }

    /**
     * 从七牛云删除
     *
     * @return
     */
    @Override
    protected boolean exec() {
        LOGGER.info("#Begin to del photo from qiniu Key is " + photoInfo);
        return QiNiuStoreFactory.getInstance().del(photoInfo.getPhotoUrl());
    }
}

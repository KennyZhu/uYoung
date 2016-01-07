package com.uyoung.core.api.task.impl;

import com.uyoung.core.api.model.AlbumInfo;
import com.uyoung.core.api.model.PhotoInfo;
import com.uyoung.core.api.service.AlbumInfoService;
import com.uyoung.core.api.service.PhotoInfoService;
import com.uyoung.core.api.task.Task;
import com.uyoung.core.base.util.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Desc:
 * <p/>Date: 2015-12-25
 * <br/>Time: 17:04
 * <br/>User: ylzhu
 */
abstract class AbsPhotoTask implements Task {

    PhotoInfo photoInfo;

    private static final Logger LOGGER = LoggerFactory.getLogger(AbsPhotoTask.class);

    protected AbsPhotoTask(PhotoInfo photoInfo) {
        this.photoInfo = photoInfo;
    }

    protected PhotoInfoService photoInfoService = SpringContextHolder.getBean("photoInfoService");

    protected AlbumInfoService albumInfoService = SpringContextHolder.getBean("albumInfoService");

    protected abstract boolean exec();

    @Override
    public Boolean call() throws Exception {
        try {
            LOGGER.info("#Begin to run:" + this.getClass().getName());
            return exec();

        } catch (Exception e) {
            LOGGER.error("#Execute PhotoTask error.Photo is :" + photoInfo + " Cause: ", e);
        }
        return false;
    }

    protected AlbumInfo getAlbumByPhotoId() {
        if (photoInfo == null) {
            return null;
        }
        return albumInfoService.getById(photoInfo.getAlbumId());
    }
}

package com.uyoung.core.api.task.impl;

import com.uyoung.core.api.model.PhotoInfo;
import com.uyoung.core.api.service.AlbumInfoService;
import com.uyoung.core.api.service.PhotoInfoService;
import com.uyoung.core.base.util.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Desc:照片浏览数处理
 * <p/>Date: 2015-12-25
 * <br/>Time: 16:34
 * <br/>User: ylzhu
 */
public class PhotoViewCountTask extends AbsPhotoTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoDeleteTask.class);

    private PhotoInfoService photoInfoService = SpringContextHolder.getBean("photoInfoService");

    protected AlbumInfoService albumInfoService = SpringContextHolder.getBean("albumInfoService");

    public PhotoViewCountTask(PhotoInfo photoInfo) {
        super(photoInfo);
    }

    @Override
    protected boolean exec() {
        try {
            albumInfoService.incViewCount(photoInfo.getAlbumId());
            return photoInfoService.incViewCount(photoInfo.getId());
        } catch (Exception e) {
            LOGGER.error("#Inc Photo View Count error.Photo is " + photoInfo + " Cause:", e);
        }
        return false;
    }
}

package com.uyoung.core.api.task.impl;

import com.uyoung.core.api.service.PhotoInfoService;
import com.uyoung.core.api.task.AbstractTask;
import com.uyoung.core.base.util.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Desc:照片浏览数处理
 * <p/>Date: 2015-12-25
 * <br/>Time: 16:34
 * <br/>User: ylzhu
 */
public class PhotoViewCountTask extends AbstractTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoDeleteTask.class);
    private Integer photoId;

    private PhotoInfoService photoInfoService = SpringContextHolder.getBean("photoInfoService");

    public PhotoViewCountTask(Integer photoId) {
        this.photoId = photoId;
    }

    @Override
    protected boolean exec() {
        try {
            return photoInfoService.incViewCount(photoId);
        } catch (Exception e) {
            LOGGER.error("#Inc Photo View Count error.PhotoId is " + photoId + " Cause:", e);
        }
        return false;
    }
}

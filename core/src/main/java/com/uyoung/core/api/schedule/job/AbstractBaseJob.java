package com.uyoung.core.api.schedule.job;

import com.uyoung.core.api.service.AlbumInfoService;
import com.uyoung.core.api.service.PhotoInfoService;
import com.uyoung.core.base.util.SpringContextHolder;

/**
 * Desc:
 * <p/>Date: 2016-01-07
 * <br/>Time: 14:23
 * <br/>User: ylzhu
 */
public abstract class AbstractBaseJob implements Job {

    protected AlbumInfoService albumInfoService = SpringContextHolder.getBean("albumInfoService");
    protected PhotoInfoService photoInfoService = SpringContextHolder.getBean("photoInfoService");
}

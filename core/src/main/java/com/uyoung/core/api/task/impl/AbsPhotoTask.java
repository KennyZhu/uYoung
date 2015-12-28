package com.uyoung.core.api.task.impl;

import com.uyoung.core.api.service.AlbumInfoService;
import com.uyoung.core.api.service.PhotoInfoService;
import com.uyoung.core.api.task.Task;
import com.uyoung.core.base.util.SpringContextHolder;

/**
 * Desc:
 * <p/>Date: 2015-12-25
 * <br/>Time: 17:04
 * <br/>User: ylzhu
 */
abstract class AbsPhotoTask implements Task {

    protected PhotoInfoService photoInfoService = SpringContextHolder.getBean("photoInfoService");

    protected AlbumInfoService albumInfoService = SpringContextHolder.getBean("albumInfoService");
}

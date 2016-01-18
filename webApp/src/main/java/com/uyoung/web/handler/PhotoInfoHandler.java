package com.uyoung.web.handler;

import com.uyoung.core.api.model.PhotoInfo;
import com.uyoung.core.api.service.PhotoInfoService;
import com.uyoung.core.api.task.TaskFactory;
import com.uyoung.core.api.task.impl.AlbumDeleteTask;
import com.uyoung.core.api.task.impl.PhotoViewCountTask;
import com.uyoung.core.third.qiniu.QiNiuConstant;
import com.uyoung.core.third.qiniu.QiNiuStoreFactory;
import com.uyoung.web.vo.PhotoInfoUrlVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Desc:
 * <p/>Date: 2015-12-24
 * <br/>Time: 10:57
 * <br/>User: ylzhu
 */
@Service
public class PhotoInfoHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoInfoHandler.class);

    @Autowired
    private PhotoInfoService photoInfoService;
    @Autowired
    private TaskFactory taskFactory;


    /**
     * 获取照片的下载URL 和 Exif URL
     *
     * @param id {@link com.uyoung.core.api.model.PhotoInfo#id}
     * @return {@link PhotoInfoUrlVo}
     */
    public PhotoInfoUrlVo getUrlVo(Integer id) {
        if (id == null) {
            return null;
        }
        PhotoInfo photoInfo = photoInfoService.getById(id);
        if (photoInfo == null) {
            LOGGER.error("#Can not found photoInfo by id:" + id);
            return null;
        }
        PhotoInfoUrlVo resultVo = new PhotoInfoUrlVo();
        String baseUrl = QiNiuConstant.getUrl(photoInfo.getPhotoUrl());
        resultVo.setDownLoadUrl(QiNiuStoreFactory.getInstance().getPrivateDownLoadUrl(baseUrl));
        resultVo.setExifUrl(QiNiuStoreFactory.getInstance().getPrivateExifUrl(baseUrl));
        taskFactory.addTask(new PhotoViewCountTask(photoInfo));
        return resultVo;
    }

    /**
     * 删除照片
     *
     * @param ids
     */
    public void delete(String ids) {
        if (StringUtils.isBlank(ids)) {
            return;
        }
        List<String> idStrList = Arrays.asList(ids.split(","));
        if (CollectionUtils.isEmpty(idStrList)) {
            return;
        }

        List<Integer> idList = new ArrayList<>(idStrList.size());
        for (String idStr : idStrList) {
            idList.add(Integer.parseInt(idStr));
        }
        List<String> photoUrls = photoInfoService.getPhotoUrlListByIdList(idList);
        if (CollectionUtils.isEmpty(photoUrls)) {
            return;
        }
        photoInfoService.deleteByIdList(idList);
        taskFactory.addTask(new AlbumDeleteTask(photoUrls));
    }
}

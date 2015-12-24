package com.uyoung.web.handler;

import com.uyoung.core.api.model.PhotoInfo;
import com.uyoung.core.api.service.PhotoInfoService;
import com.uyoung.core.third.qiniu.QiNiuAccessTokenFactory;
import com.uyoung.web.vo.PhotoInfoUrlVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        String baseUrl = photoInfo.getPhotoUrl();
        resultVo.setDownLoadUrl(QiNiuAccessTokenFactory.getInstance().getPrivateDownLoadUrl(baseUrl));
        resultVo.setExifUrl(QiNiuAccessTokenFactory.getInstance().getPrivateExifUrl(baseUrl));
        return resultVo;
    }
}

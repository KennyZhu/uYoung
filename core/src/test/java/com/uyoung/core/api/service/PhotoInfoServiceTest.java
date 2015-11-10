package com.uyoung.core.api.service;

import com.uyoung.core.api.BaseTest;
import com.uyoung.core.api.model.PhotoInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Desc:
 * <p/>Date: 2015-11-10
 * <br/>Time: 17:05
 * <br/>User: ylzhu
 */
public class PhotoInfoServiceTest extends BaseTest {

    @Autowired
    private PhotoInfoService photoInfoService;

    @Test
    public void add() {
        PhotoInfo photoInfo = new PhotoInfo();
        photoInfo.setCreateUserId(1);
        photoInfo.setAlbumId(1);
        photoInfo.setPhotoName("测试照片1");
        photoInfo.setPhotoUrl("http://www.baidu.com");
        photoInfoService.add(photoInfo);
    }
}

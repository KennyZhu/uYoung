package com.uyoung.core.api.service;

import com.uyoung.core.api.BaseTest;
import com.uyoung.core.api.model.AlbumInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Desc:
 * <p/>Date: 2015-10-20
 * <br/>Time: 14:40
 * <br/>User: ylzhu
 */
public class AlbumInfoServiceTest extends BaseTest {
    @Autowired
    private AlbumInfoService service;

    @Test
    public void getPageByUid() {
        LOGGER.info("####" + service.getPageByCreateUserId(1, null, null));
    }


    @Test
    public void insert() {
        AlbumInfo albumInfo = new AlbumInfo();
        albumInfo.setActivityId(1);
        albumInfo.setAlbumName("测试相册");
        albumInfo.setAlbumUrl("http://www.baidu.com");
        albumInfo.setCreateUserId(1);
        albumInfo.setFirstPhotoUrl("http://www.baidu.com");
        albumInfo.setTitle("测试Title");
//        albumInfo.setCreateTime(new Date());
        LOGGER.info("###" + service.add(albumInfo));
    }
}

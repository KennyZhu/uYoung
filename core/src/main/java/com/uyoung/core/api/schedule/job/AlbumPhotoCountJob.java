package com.uyoung.core.api.schedule.job;

import com.uyoung.core.api.model.AlbumInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Desc:更新总的照片数
 * <p/>Date: 2016-01-07
 * <br/>Time: 14:23
 * <br/>User: ylzhu
 */
public class AlbumPhotoCountJob extends AbstractBaseJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlbumPhotoCountJob.class);

    @Override
    public void run() {
        LOGGER.info("#Begin to run album photo count job.");
        try {
            List<AlbumInfo> albumInfos = albumInfoService.getAllAlbumCount();
            for (AlbumInfo albumInfo : albumInfos) {
                int totalCount = photoInfoService.getTotalCountByAlbumId(albumInfo.getId());
                if (totalCount != 0 || totalCount != albumInfo.getTotalPhotoCount()) {
                    boolean result = albumInfoService.updateTotalPhotoCount(albumInfo.getId(), totalCount);
                    LOGGER.info("#Begin to update album total photo count from" + albumInfo.getTotalPhotoCount() + " to " + totalCount + " return " + result);
                }
            }
        } catch (Exception e) {
            LOGGER.error("#Album photo count job error.Cause:", e);
        }
    }
}

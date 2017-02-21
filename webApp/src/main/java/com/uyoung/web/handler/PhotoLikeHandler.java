package com.uyoung.web.handler;

import com.uyoung.core.api.model.PhotoInfo;
import com.uyoung.core.api.model.PhotoLike;
import com.uyoung.core.api.mq.KafkaProducerFactory;
import com.uyoung.core.api.service.PhotoInfoService;
import com.uyoung.core.api.service.PhotoLikeService;
import com.uyoung.core.api.task.TaskFactory;
import com.uyoung.core.api.task.impl.PhotoDecLikeCountTask;
import com.uyoung.core.api.task.impl.PhotoIncLikeCountTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Desc:
 * <p/>Date: 2015-11-10
 * <br/>Time: 16:30
 * <br/>User: ylzhu
 */
@Repository
public class PhotoLikeHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoLikeHandler.class);
    @Autowired
    private PhotoLikeService photoLikeService;

    @Autowired
    private PhotoInfoService photoInfoService;

    @Autowired
    private TaskFactory taskFactory;

    /**
     * 照片点赞（并发问题）
     *
     * @param uid
     * @param photoId
     * @return
     */
    public boolean like(Integer uid, Integer photoId) {
        if (uid == null || photoId == null) {
            LOGGER.error("#Invalid param.");
            return false;
        }

        PhotoInfo photoInfo = photoInfoService.getById(photoId);
        if (photoInfo == null) {
            LOGGER.error("#Can not found photoById:" + photoId);
            return false;
        }
        PhotoLike photoLike = photoLikeService.getByUidPhotoId(uid, photoId);
        if (photoLike == null) {
            photoLike = new PhotoLike();
            photoLike.setPhotoId(photoId);
            photoLike.setUserId(uid);
            if (photoLikeService.add(photoLike)) {
                taskFactory.addTask(new PhotoIncLikeCountTask(photoInfo));
            }
        } else {
            LOGGER.info("#Begin to sendMsg.");
            KafkaProducerFactory.getInstance().sendMsg("default", "#uid:" + uid + " photoId:" + photoId + " like.");
            if (photoLikeService.delete(uid, photoId)) {
                taskFactory.addTask(new PhotoDecLikeCountTask(photoInfo));
            }
        }
        return true;
    }
}

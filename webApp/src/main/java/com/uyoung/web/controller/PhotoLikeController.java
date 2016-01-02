package com.uyoung.web.controller;

import com.uyoung.core.api.model.PhotoLike;
import com.uyoung.core.api.service.PhotoLikeService;
import com.uyoung.web.controller.base.BaseController;
import com.uyoung.web.handler.PhotoLikeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Desc:照片点赞
 * <p/>Date: 2015-11-09
 * <br/>Time: 11:55
 * <br/>User: ylzhu
 */
@Controller
public class PhotoLikeController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoLikeController.class);

    @Autowired
    private PhotoLikeService photoLikeService;

    @Autowired
    private PhotoLikeHandler handler;

    @RequestMapping(value = "/photoLike/like")
    @ResponseBody
    public String like(Integer uid, Integer photoId) {
        if (uid == null || photoId == null) {
            return buildInvalidParamJson();
        }
        try {
            boolean result = handler.like(uid, photoId);
            if (!result) {
                LOGGER.warn("#Like by uid:" + uid + " photoId:" + photoId + " return false.");
            }
            return buildSuccessJson();
        } catch (Exception e) {
            LOGGER.error("#Photo like error.Cause:", e);
            return buildExceptionJson();
        }
    }

    @RequestMapping(value = "/photoLike/get")
    @ResponseBody
    public String getByUidPhotoId(Integer uid, Integer photoId) {
        if (uid == null || photoId == null) {
            return buildInvalidParamJson();
        }
        try {
            PhotoLike photoLike = photoLikeService.getByUidPhotoId(uid, photoId);
            return buildSuccessJson(photoLike != null);
        } catch (Exception e) {
            LOGGER.error("#Photo unlike error.Cause:", e);
            return buildExceptionJson();
        }
    }
}

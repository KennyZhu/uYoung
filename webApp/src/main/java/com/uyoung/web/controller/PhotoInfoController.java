package com.uyoung.web.controller;

import com.uyoung.core.api.model.PhotoInfo;
import com.uyoung.core.api.service.PhotoInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Desc:
 * <p/>Date: 2015-11-10
 * <br/>Time: 16:57
 * <br/>User: ylzhu
 */
@Controller
public class PhotoInfoController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoInfoController.class);
    @Autowired
    private PhotoInfoService photoInfoService;

    @RequestMapping(value = "/photo/add", method = RequestMethod.POST)
    @ResponseBody
    public String add(PhotoInfo photoInfo) {
        if (photoInfo == null) {
            return buildInvalidParamJson();
        }
        try {
            photoInfoService.add(photoInfo);
            return buildSuccessJson();
        } catch (Exception e) {
            LOGGER.error("#Add Photo error.Cause:", e);
            return buildExceptionJson();
        }
    }
}

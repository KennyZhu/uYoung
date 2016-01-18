package com.uyoung.web.controller;

import com.uyoung.core.api.model.PhotoInfo;
import com.uyoung.core.api.service.PhotoInfoService;
import com.uyoung.web.controller.base.BaseController;
import com.uyoung.web.handler.PhotoInfoHandler;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Desc:照片信息
 * <p/>Date: 2015-11-10
 * <br/>Time: 16:57
 * <br/>User: ylzhu
 */
@Controller
public class PhotoInfoController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoInfoController.class);
    @Autowired
    private PhotoInfoService photoInfoService;

    @Autowired
    private PhotoInfoHandler handler;

    @RequestMapping(value = "/photo/add", method = RequestMethod.POST)
    @ResponseBody
    public String add(PhotoInfo photoInfo) {
        if (photoInfo == null) {
            return buildInvalidParamJson();
        }
        try {
            photoInfoService.add(photoInfo);
            return buildSuccessJson(photoInfo.getId());
        } catch (Exception e) {
            LOGGER.error("#Add Photo error.Cause:", e);
            return buildExceptionJson();
        }
    }

    /**
     * 照片上传接口
     *
     * @param photoInfo
     * @return
     */
    @RequestMapping(value = "/photo/updateById", method = RequestMethod.POST)
    @ResponseBody
    public String updateById(PhotoInfo photoInfo) {
        if (photoInfo == null) {
            return buildInvalidParamJson();
        }
        try {
            photoInfoService.updateById(photoInfo);
            return buildSuccessJson();
        } catch (Exception e) {
            LOGGER.error("#Update Photo error.Cause:", e);
            return buildExceptionJson();
        }
    }

    /**
     * 照片下载接口
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/photo/downloadUrl")
    @ResponseBody
    public String downLoadUrl(Integer id) {

        if (id == null) {
            return buildInvalidParamJson();
        }
        try {
            return buildSuccessJson(handler.getUrlVo(id));
        } catch (Exception e) {
            LOGGER.error("#Update Photo error.Cause:", e);
            return buildExceptionJson();
        }
    }

    @RequestMapping(value = "/photo/deleteById")
    @ResponseBody
    public String deleteById(String ids) {
        if (StringUtils.isBlank(ids)) {
            return buildInvalidParamJson();
        }
        try {
            handler.delete(ids);
            return buildSuccessJson();
        } catch (Exception e) {
            LOGGER.error("#Delete Photo error.Id:" + ids + " Cause:", e);
            return buildExceptionJson();
        }
    }
}

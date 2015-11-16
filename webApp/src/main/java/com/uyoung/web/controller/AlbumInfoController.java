package com.uyoung.web.controller;

import com.uyoung.core.api.model.AlbumInfo;
import com.uyoung.core.api.service.AlbumInfoService;
import com.uyoung.core.base.bean.Page;
import com.uyoung.web.handler.AlbumInfoBuilder;
import com.uyoung.web.vo.AlbumInfoVo;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Desc:相册信息
 * <p/>Date: 2015-10-20
 * <br/>Time: 16:41
 * <br/>User: ylzhu
 */
@Controller
public class AlbumInfoController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlbumInfoController.class);
    @Autowired
    private AlbumInfoService albumInfoService;

    @RequestMapping(value = "/album/getByUid")
    @ResponseBody
    public String getByUid(Integer uid, Integer page, Integer pageSize) {
        if (uid == null) {
            return buildInvalidParamJson();
        }

        try {
            Page<AlbumInfo> albumInfoPage = albumInfoService.getPageByCreateUserId(uid, page, pageSize);
            if (albumInfoPage != null && CollectionUtils.isNotEmpty(albumInfoPage.getDataList())) {
                AlbumInfoBuilder albumInfoBuilder = new AlbumInfoBuilder(albumInfoPage);
                Page<AlbumInfoVo> result = albumInfoBuilder.builderAlbumInfoVoPage().getAlbumInfoVoPage();
                return buildSuccessJson(result);
            }
        } catch (Exception e) {
            LOGGER.error("#Get Album List by uid :" + uid + " error.Cause:", e);
            return buildExceptionJson();
        }

        return buildEmptyPageJson(page, pageSize);
    }

    @RequestMapping(value = "/album/add")
    @ResponseBody
    public String add(AlbumInfo albumInfo) {
        if (albumInfo == null) {
            return buildInvalidParamJson();
        }
        try {
            albumInfoService.add(albumInfo);
        } catch (Exception e) {
            LOGGER.error("#Add albumInfo error.Cause:", e);
            return buildExceptionJson();
        }
        return buildSuccessJson();
    }
}

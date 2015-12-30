package com.uyoung.web.controller;

import com.uyoung.core.api.exception.BusinessException;
import com.uyoung.core.api.model.AlbumInfo;
import com.uyoung.core.api.service.AlbumInfoService;
import com.uyoung.core.base.bean.Page;
import com.uyoung.web.enums.ResultCodeEnum;
import com.uyoung.web.handler.AlbumInfoBuilder;
import com.uyoung.web.handler.AlbumInfoHandler;
import com.uyoung.web.vo.AlbumDetailVo;
import com.uyoung.web.vo.AlbumInfoVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @Autowired
    private AlbumInfoHandler handler;

    /**
     * 获取用户创建的相册
     *
     * @param uid
     * @param page
     * @param pageSize
     * @return
     */
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

    /**
     * 添加相册
     *
     * @param albumInfo
     * @return
     */
    @RequestMapping(value = "/album/add", method = RequestMethod.POST)
    @ResponseBody
    public String add(AlbumInfo albumInfo) {
        if (albumInfo == null) {
            return buildInvalidParamJson();
        }
        try {
            int result = albumInfoService.add(albumInfo);
        } catch (Exception e) {
            LOGGER.error("#Add albumInfo error.Cause:", e);
            return buildExceptionJson();
        }
        return buildSuccessJson(albumInfo);
    }

    /**
     * 更新相册
     *
     * @param albumInfo
     * @return
     */
    @RequestMapping(value = "/album/updateById", method = RequestMethod.POST)
    @ResponseBody
    public String updateById(AlbumInfo albumInfo) {
        if (albumInfo == null || albumInfo.getId() == null) {
            return buildInvalidParamJson();
        }
        try {
            albumInfoService.updateById(albumInfo);
        } catch (Exception e) {
            LOGGER.error("#Update albumInfo error.Cause:", e);
            return buildExceptionJson();
        }
        return buildSuccessJson();
    }

    /**
     * 删除相册
     *
     * @param id
     * @param uid
     * @return
     */
    @RequestMapping(value = "/album/deleteById", method = RequestMethod.POST)
    @ResponseBody
    public String deleteById(Integer id, Integer uid) {
        if (id == null || uid == null) {
            return buildInvalidParamJson();
        }
        try {

            handler.deleteById(uid, id);
        } catch (BusinessException busE) {
            LOGGER.error("#Delete activity error.Uid is " + uid + " id is " + id + "Cause:", busE);
            return buildFailJson(ResultCodeEnum.getByCode(Integer.valueOf(busE.getMessage())).getDesc());
        } catch
                (Exception e) {
            LOGGER.error("#Delete albumInfo error.Cause:", e);
            return buildExceptionJson();
        }
        return buildSuccessJson();
    }

    /**
     * 相册详情
     *
     * @param albumId
     * @return TODO
     */
    @RequestMapping(value = "/album/getDetailById")
    @ResponseBody
    public String getDetailById(Integer albumId) {
        if (albumId == null) {
            return buildInvalidParamJson();
        }
        try {
            AlbumDetailVo detailVo = handler.getAlbumDetailById(albumId);
            return buildSuccessJson(detailVo);
        } catch (Exception e) {
            LOGGER.error("#Add albumInfo error.Cause:", e);
            return buildExceptionJson();
        }
    }

    /**
     * 更新相册封面URL
     *
     * @param id
     * @param url
     * @return
     */
    @RequestMapping(value = "/album/updateFirstUrl", method = RequestMethod.POST)
    @ResponseBody
    public String updateFirstUrl(Integer id, String url) {
        if (id == null || StringUtils.isBlank(url)) {
            return buildInvalidParamJson();
        }
        try {
            boolean result = albumInfoService.updateFirstPhotoUrl(id, url);
            if (!result) {
                return buildFailJson();
            }
        } catch (Exception e) {
            LOGGER.error("#UpdateFirstUrl error.Id is " + id + " firstPhotoUrl is " + url + "Cause:", e);
            return buildExceptionJson();
        }
        return buildSuccessJson();
    }
}

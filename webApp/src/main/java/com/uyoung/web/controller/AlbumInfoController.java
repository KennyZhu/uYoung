package com.uyoung.web.controller;

import com.uyoung.core.api.model.AlbumInfo;
import com.uyoung.core.api.service.AlbumInfoService;
import com.uyoung.core.base.bean.Page;
import com.uyoung.web.handler.AlbumInfoBuilder;
import com.uyoung.web.util.JsonUtil;
import com.uyoung.web.vo.AlbumInfoVo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Desc:
 * <p/>Date: 2015-10-20
 * <br/>Time: 16:41
 * <br/>User: ylzhu
 */
@Controller
public class AlbumInfoController extends BaseController {

    @Autowired
    private AlbumInfoService albumInfoService;

    @RequestMapping(value = "/album/getByUid")
    @ResponseBody
    public String getByUid(Integer uid, Integer page, Integer pageSize) {
        if (uid == null) {
            return buildInvalidParamResult();
        }

        Page<AlbumInfo> albumInfoPage = albumInfoService.getPageByCreateUserId(uid, page, pageSize);
        if (albumInfoPage != null && CollectionUtils.isNotEmpty(albumInfoPage.getDataList())) {
            AlbumInfoBuilder albumInfoBuilder = new AlbumInfoBuilder(albumInfoPage);
            Page<AlbumInfoVo> result = albumInfoBuilder.builderAlbumInfoVoPage().getAlbumInfoVoPage();
            return JsonUtil.getJsonString(result);
        }

        return JsonUtil.getJsonString(albumInfoPage);
    }
}

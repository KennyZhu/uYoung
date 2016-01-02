package com.uyoung.web.controller.base;

import com.uyoung.core.api.exception.BusinessException;
import com.uyoung.core.api.model.AlbumInfo;
import com.uyoung.core.api.service.AlbumInfoService;
import com.uyoung.web.enums.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Desc:
 * <p/>Date: 2015-12-30
 * <br/>Time: 15:03
 * <br/>User: ylzhu
 */
public class AlbumBaseController extends BaseController {

    @Autowired
    private AlbumInfoService albumInfoService;

    /**
     * 校验ID是否为当前登录用户的相册ID
     *
     * @param id
     * @return
     */
    protected boolean checkUser(Integer id) throws Exception {
        Integer uid = getCurrentLoginUid();
        if (uid == null) {
            throw new BusinessException(ResultCodeEnum.NOT_LOGIN);
        }
        AlbumInfo albumInfo = albumInfoService.getById(id);
        if (albumInfo == null) {
            throw new BusinessException(ResultCodeEnum.ALBUM_NOT_FOUND);
        }
        if (!uid.equals(albumInfo.getCreateUserId())) {
            throw new BusinessException(ResultCodeEnum.ALBUM_NOT_CREATOR);
        }
        return true;
    }
}

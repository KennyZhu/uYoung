package com.uyoung.web.handler;

import com.uyoung.core.api.model.AlbumInfo;
import com.uyoung.core.api.model.PhotoInfo;
import com.uyoung.core.api.model.UserInfo;
import com.uyoung.core.api.service.AlbumInfoService;
import com.uyoung.core.api.service.PhotoInfoService;
import com.uyoung.core.api.service.UserInfoService;
import com.uyoung.web.vo.AlbumDetailVo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: KennyZhu
 * Date: 15/12/9
 * Desc:
 */
@Service
public class AlbumInfoHandler {
    @Autowired
    private AlbumInfoService albumInfoService;
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private PhotoInfoService photoInfoService;

    public AlbumDetailVo getAlbumDetailById(Integer id) {
        if (id == null) {
            return null;
        }

        AlbumInfo info = albumInfoService.getById(id);
        if (info == null) {
            return null;
        }
        UserInfo userInfo = userInfoService.getById(info.getCreateUserId());
        if (userInfo == null) {
            return null;
        }
        AlbumDetailVo detailVo = new AlbumDetailVo();
        detailVo.setAlbumId(info.getId());
        detailVo.setOriUserId(info.getCreateUserId());

        detailVo.setOriUrl(userInfo.getAvatarUrl());
        detailVo.setOriNickName(userInfo.getNickName());
        detailVo.setCreateTime(info.getCreateTime());
        detailVo.setPhotoNum(info.getTotalPhotoCount());
        detailVo.setAlbumDesc(info.getAlbumName());
        List<PhotoInfo> photoInfos = photoInfoService.getListByAlbumId(info.getId());
        if (CollectionUtils.isNotEmpty(photoInfos)) {
            detailVo.setPhotoInfoList(photoInfos);
        }
        return detailVo;
    }
}

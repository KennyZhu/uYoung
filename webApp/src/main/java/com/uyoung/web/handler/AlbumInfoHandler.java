package com.uyoung.web.handler;

import com.uyoung.core.api.model.AlbumInfo;
import com.uyoung.core.api.model.PhotoInfo;
import com.uyoung.core.api.model.UserInfo;
import com.uyoung.core.api.service.AlbumInfoService;
import com.uyoung.core.api.service.PhotoInfoService;
import com.uyoung.core.api.service.UserInfoService;
import com.uyoung.core.api.task.TaskFactory;
import com.uyoung.core.api.task.impl.AlbumDeleteTask;
import com.uyoung.web.vo.AlbumDetailVo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private TaskFactory taskFactory;

    /**
     * 构造相册详情
     *
     * @param id
     * @return
     */
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

    /**
     * @param id
     */
    public void deleteById(Integer id) {
        if (id == null) {
            return;
        }
        AlbumInfo albumInfo = albumInfoService.getById(id);
        if (albumInfo == null) {
            return;
        }

        albumInfoService.deleteById(id);
        List<PhotoInfo> photoInfos = photoInfoService.getListByAlbumId(id);
        if (CollectionUtils.isNotEmpty(photoInfos)) {
            List<String> keys = new ArrayList<>(photoInfos.size());
            for (PhotoInfo photoInfo : photoInfos) {
                keys.add(photoInfo.getPhotoUrl());
            }

            photoInfoService.deleteByAlbumId(id);
            taskFactory.addTask(new AlbumDeleteTask(keys));
        }
    }
}

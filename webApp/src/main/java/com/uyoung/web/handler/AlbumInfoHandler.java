package com.uyoung.web.handler;

import com.uyoung.core.api.model.AlbumInfo;
import com.uyoung.core.api.model.PhotoInfo;
import com.uyoung.core.api.model.UserInfo;
import com.uyoung.core.api.service.AlbumInfoService;
import com.uyoung.core.api.service.PhotoInfoService;
import com.uyoung.core.api.service.UserInfoService;
import com.uyoung.core.api.task.TaskFactory;
import com.uyoung.core.api.task.impl.AlbumDeleteTask;
import com.uyoung.web.vo.AlbumActivityVo;
import com.uyoung.web.vo.AlbumDetailVo;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * User: KennyZhu
 * Date: 15/12/9
 * Desc:
 */
@Service
public class AlbumInfoHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlbumInfoHandler.class);
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
            LOGGER.error("Invalid param.");
            return null;
        }

        AlbumInfo info = albumInfoService.getById(id);
        if (info == null) {
            LOGGER.error("#Get albumInfo by id :" + id + " return null.");
            return null;
        }
        UserInfo userInfo = userInfoService.getById(info.getCreateUserId());
        if (userInfo == null) {
            LOGGER.error("#Get userInfo by userId:" + info.getCreateUserId() + " return null.");
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
     * 根据活动获取相册信息
     *
     * @param activityId
     * @return
     */
    public List<AlbumActivityVo> getAlbumActivityByActivityId(Integer activityId) {
        if (activityId == null) {
            return Collections.emptyList();
        }

        List<AlbumInfo> albumInfos = albumInfoService.getListByActivityId(activityId);
        if (CollectionUtils.isEmpty(albumInfos)) {
            return Collections.emptyList();
        }
        List<Integer> oriUserIds = new ArrayList<>(albumInfos.size());
        for (AlbumInfo albumInfo : albumInfos) {
            oriUserIds.add(albumInfo.getCreateUserId());
        }
        Map<Integer, UserInfo> userInfoMap = userInfoService.getMapByIdList(oriUserIds);
        List<AlbumActivityVo> result = new ArrayList<>(albumInfos.size());
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        String today = sdf.format(new Date());
        for (AlbumInfo albumInfo : albumInfos) {
            AlbumActivityVo vo = new AlbumActivityVo();
            vo.setActivityId(activityId);
            vo.setAlbumId(albumInfo.getId());
            String createTime = sdf.format(albumInfo.getCreateTime());
            vo.setCreateTime(today.equals(createTime) ? "today" : createTime);
            vo.setFirstPhotoUrl(albumInfo.getFirstPhotoUrl());
            UserInfo userInfo = userInfoMap.get(albumInfo.getCreateUserId());
            if (userInfo != null) {
                vo.setOriUrl(userInfo.getAvatarUrl());
            }
            vo.setTotalLikeCount(albumInfo.getTotalLikeCount());
            vo.setTotalPhotoCount(albumInfo.getTotalPhotoCount());

            result.add(vo);
        }

        return result;
    }

    /**
     * 删除相册
     *
     * @param id
     */
    public void deleteById(Integer uid, Integer id) throws Exception {
        if (id == null || uid == null) {
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

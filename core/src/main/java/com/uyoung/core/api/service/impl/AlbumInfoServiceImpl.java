package com.uyoung.core.api.service.impl;

import com.uyoung.core.api.dao.AlbumInfoDao;
import com.uyoung.core.api.model.AlbumInfo;
import com.uyoung.core.api.service.AlbumInfoService;
import com.uyoung.core.base.bean.Page;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Service("albumInfoService")
public class AlbumInfoServiceImpl implements AlbumInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlbumInfoServiceImpl.class);

    @Autowired
    private AlbumInfoDao albumInfoDao;

    @Override
    public int add(AlbumInfo albumInfo) {
        if (albumInfo == null) {
            return 0;
        }
        Date now = new Date();
        albumInfo.setCreateTime(now);
        albumInfo.setUpdateTime(now);
        return albumInfoDao.insert(albumInfo);
    }

    @Override
    public AlbumInfo getById(Integer id) {
        if (id == null) {
            return null;
        }
        return albumInfoDao.getById(id);
    }

    @Override
    public List<AlbumInfo> getListByActivityId(Integer activityId) {
        if (activityId == null) {
            return null;
        }
        return albumInfoDao.getListByActivityId(activityId);

    }

    @Override
    public int updateById(AlbumInfo albumInfo) {
        if (albumInfo == null || albumInfo.getId() == null) {
            LOGGER.error("#Invalid param.");
            return 0;
        }

        return albumInfoDao.updateById(albumInfo);

    }

    @Override
    public int deleteById(Integer id) {
        if (id == null) {
            return 0;
        }
        return albumInfoDao.deleteById(id);
    }

    @Override
    public Page<AlbumInfo> getPageByCreateUserId(Integer createUserId, Integer page, Integer pageNum) {
        Page<AlbumInfo> result = new Page<>();
        if (createUserId == null) {
            return result;
        }
        return albumInfoDao.getPageByCreateUserId(createUserId, page, pageNum);
    }

    @Override
    public boolean decLikeCount(Integer id) {
        if (id == null) {
            return false;
        }
        return albumInfoDao.decLikeCount(id) == 1;
    }

    @Override
    public boolean incLikeCount(Integer id) {
        if (id == null) {
            LOGGER.error("#Invalid param.");
            return false;
        }
        return albumInfoDao.incLikeCount(id) == 1;
    }

    @Override
    public boolean updateFirstPhotoUrl(Integer id, String firstPhotoUrl) {
        if (id == null || StringUtils.isBlank(firstPhotoUrl)) {
            return false;
        }
        return albumInfoDao.updateFirstPhotoUrl(id, firstPhotoUrl) == 1;
    }

    @Override
    public List<AlbumInfo> getAllAlbumCount() {
        return albumInfoDao.getAllAlbumCount();
    }

    @Override
    public boolean updateTotalPhotoCount(Integer id, int totalCount) {
        if (id == null || totalCount == 0) {
            return false;
        }
        return albumInfoDao.updateTotalPhotoCount(id, totalCount) == 1;
    }
}

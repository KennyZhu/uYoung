package com.uyoung.core.api.service.impl;

import com.uyoung.core.api.dao.AlbumInfoDao;
import com.uyoung.core.api.model.AlbumInfo;
import com.uyoung.core.api.service.AlbumInfoService;
import com.uyoung.core.base.bean.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
    public int decLikeCount(Integer id) {
        if (id == null) {
            return 0;
        }
        return albumInfoDao.decLikeCount(id);
    }

    @Override
    public int incLikeCount(Integer id) {
        if (id == null) {
            return 0;
        }
        return albumInfoDao.incLikeCount(id);
    }

    @Override
    public boolean updateFirstPhotoUrl(Integer id, String firstPhotoUrl) {
        if (id == null || firstPhotoUrl == null) {
            return false;
        }
        return albumInfoDao.updateFirstPhotoUrl(id, firstPhotoUrl) == 1;
    }
}

package com.uyoung.core.api.service.impl;

import com.uyoung.core.api.dao.AlbumInfoDao;
import com.uyoung.core.api.model.AlbumInfo;
import com.uyoung.core.api.service.AlbumInfoService;
import com.uyoung.core.base.bean.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Service("albumInfoService")
public class AlbumInfoServiceImpl implements AlbumInfoService {

    @Autowired
    private AlbumInfoDao albumInfoDao;

    @Override
    public int add(AlbumInfo albumInfo) {
        if (albumInfo == null) {
            return 0;
        }
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
}

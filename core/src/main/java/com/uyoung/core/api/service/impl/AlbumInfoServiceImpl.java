package com.uyoung.core.api.service.impl;

import com.uyoung.core.api.dao.AlbumInfoDao;
import com.uyoung.core.api.model.AlbumInfo;
import com.uyoung.core.api.service.AlbumInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Service
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
    public AlbumInfo getById(int id) {
        return albumInfoDao.getById(id);
    }
}

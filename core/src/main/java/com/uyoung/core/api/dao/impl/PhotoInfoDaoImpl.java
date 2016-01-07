package com.uyoung.core.api.dao.impl;

import com.uyoung.core.api.dao.PhotoInfoDao;
import com.uyoung.core.api.model.PhotoInfo;
import com.uyoung.core.base.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Repository
public class PhotoInfoDaoImpl extends BaseDao<PhotoInfo> implements PhotoInfoDao {
    @Override
    public int deleteById(Integer id) {
        return delete("deleteById", id);
    }

    @Override
    public int insert(PhotoInfo record) {
        return insert("insert", record);
    }

    @Override
    public PhotoInfo getById(Integer id) {
        return selectOne("getById", id);
    }

    @Override
    public int getTotalCountByAlbumId(Integer albumId) {
        return (Integer) select("getTotalCountByAlbumId", albumId);
    }

    @Override
    public int updateById(PhotoInfo record) {
        return update("updateById", record);
    }

    @Override
    public int deleteByAlbumId(Integer albumId) {
        return delete("deleteByAlbumId", albumId);
    }

    @Override
    public List<PhotoInfo> getListByAlbumId(Integer albumId) {
        return selectList("getListByAlbumId", albumId);
    }

    @Override
    public int incLikeCount(Integer id) {
        return update("incLikeCount", id);
    }

    @Override
    public int decLikeCount(Integer id) {
        return update("decLikeCount", id);
    }

    @Override
    public int incViewCount(Integer id) {
        return update("incViewCount", id);
    }
}

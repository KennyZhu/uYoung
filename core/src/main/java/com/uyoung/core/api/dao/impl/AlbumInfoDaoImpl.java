package com.uyoung.core.api.dao.impl;

import com.uyoung.core.api.dao.AlbumInfoDao;
import com.uyoung.core.api.model.AlbumInfo;
import com.uyoung.core.base.bean.Page;
import com.uyoung.core.base.dao.BaseDao;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Repository
public class AlbumInfoDaoImpl extends BaseDao<AlbumInfo> implements AlbumInfoDao {
    @Override
    public int deleteById(Integer id) {
        return delete("deleteById", id);
    }

    @Override
    public int insert(AlbumInfo record) {
        return insert("insert", record);
    }

    @Override
    public AlbumInfo getById(Integer id) {
        return selectOne("getById", id);
    }

    @Override
    public int updateById(AlbumInfo record) {
        return 0;
    }

    @Override
    public Page<AlbumInfo> getPageByCreateUserId(Integer cuid, Integer page, Integer pageSize) {
        Map<String, Object> param = new HashMap<>();
        param.put("cuid", cuid);
        if (page == null || pageSize == null) {
            return selectPage("getPageByCreateUserId", param, RowBounds.DEFAULT);
        }
        int offset = pageSize * (page - 1) + 1;
        return selectPage("getPageByCreateUserId", param, new RowBounds(offset, pageSize));
    }
}

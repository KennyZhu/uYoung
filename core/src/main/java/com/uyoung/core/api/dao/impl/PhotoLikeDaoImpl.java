package com.uyoung.core.api.dao.impl;

import com.uyoung.core.api.dao.PhotoLikeDao;
import com.uyoung.core.api.model.PhotoLike;
import com.uyoung.core.base.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Repository
public class PhotoLikeDaoImpl extends BaseDao implements PhotoLikeDao {
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int deleteByUidPhotoId(Integer uid, Integer photoId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("uid", uid);
        paramMap.put("photoId", photoId);
        return delete("deleteByUidPhotoId", paramMap);
    }

    @Override
    public int insert(PhotoLike record) {
        return insert("insert", record);
    }

    @Override
    public PhotoLike getById(Integer id) {
        return null;
    }
}

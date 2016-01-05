package com.uyoung.core.api.dao.impl;

import com.uyoung.core.api.dao.FeedBackDao;
import com.uyoung.core.api.model.FeedBack;
import com.uyoung.core.base.dao.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * Desc:
 * <p/>Date: 2016-01-04
 * <br/>Time: 18:05
 * <br/>User: ylzhu
 */
@Repository
public class FeedBackDaoImpl extends BaseDao<FeedBack> implements FeedBackDao {
    @Override
    public int insert(FeedBack feedBack) {
        return insert("insert", feedBack);
    }
}

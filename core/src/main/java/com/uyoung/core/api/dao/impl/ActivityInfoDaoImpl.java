package com.uyoung.core.api.dao.impl;

import com.uyoung.core.api.dao.ActivityInfoDao;
import com.uyoung.core.api.model.ActivityInfo;
import com.uyoung.core.base.bean.Page;
import com.uyoung.core.base.dao.BaseDao;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Repository
public class ActivityInfoDaoImpl extends BaseDao<ActivityInfo> implements ActivityInfoDao {

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(ActivityInfo record) {
        return 0;
    }

    @Override
    public ActivityInfo getById(Integer id) {
        return selectOne("getById", id);
    }

    @Override
    public int updateById(ActivityInfo record) {
        return 0;
    }

    @Override
    public Page<ActivityInfo> getPageByStatus(int offset, int limit, int status) {
        return selectPage("getPageByStatus", status, new RowBounds(offset, limit));
    }
}

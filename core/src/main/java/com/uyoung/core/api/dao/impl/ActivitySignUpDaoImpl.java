package com.uyoung.core.api.dao.impl;

import com.uyoung.core.api.dao.ActivitySignUpDao;
import com.uyoung.core.api.model.ActivitySignUp;
import com.uyoung.core.base.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Repository
public class ActivitySignUpDaoImpl extends BaseDao<ActivitySignUp> implements ActivitySignUpDao {
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(ActivitySignUp record) {
        return insert("insert", record);
    }

    @Override
    public ActivitySignUp getById(Integer id) {
        return selectOne("getById", id);
    }

    @Override
    public int updateById(ActivitySignUp record) {
        return 0;
    }

    @Override
    public List<ActivitySignUp> getListByActivityId(Integer aid) {
        return selectList("getListByActivityId", aid);
    }
}

package com.uyoung.core.api.dao.impl;

import com.uyoung.core.api.dao.ActivitySignUpDao;
import com.uyoung.core.api.model.ActivitySignUp;
import org.springframework.stereotype.Repository;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Repository
public class ActivitySignUpDaoImpl implements ActivitySignUpDao {
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(ActivitySignUp record) {
        return 0;
    }

    @Override
    public ActivitySignUp getById(Integer id) {
        return null;
    }

    @Override
    public int updateById(ActivitySignUp record) {
        return 0;
    }
}

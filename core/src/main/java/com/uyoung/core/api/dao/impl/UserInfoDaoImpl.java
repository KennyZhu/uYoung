package com.uyoung.core.api.dao.impl;

import com.uyoung.core.api.dao.UserInfoDao;
import com.uyoung.core.api.model.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Repository
public class UserInfoDaoImpl implements UserInfoDao {
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(UserInfo record) {
        return 0;
    }

    @Override
    public UserInfo getById(Integer id) {
        return null;
    }

    @Override
    public int updateById(UserInfo record) {
        return 0;
    }
}

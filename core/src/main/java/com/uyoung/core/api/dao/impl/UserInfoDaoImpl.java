package com.uyoung.core.api.dao.impl;

import com.uyoung.core.api.dao.UserInfoDao;
import com.uyoung.core.api.model.UserInfo;
import com.uyoung.core.base.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Repository
public class UserInfoDaoImpl extends BaseDao<UserInfo> implements UserInfoDao {
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
        return selectOne("getById", id);
    }

    @Override
    public int updateById(UserInfo record) {
        return 0;
    }

    @Override
    public List<UserInfo> getAvatarListByUserIdList(List<Integer> userIds) {
        return null;
    }
}

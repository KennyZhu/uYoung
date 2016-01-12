package com.uyoung.core.api.dao.impl;

import com.uyoung.core.api.dao.UserInfoDao;
import com.uyoung.core.api.model.UserInfo;
import com.uyoung.core.base.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Repository
public class UserInfoDaoImpl extends BaseDao<UserInfo> implements UserInfoDao {
    @Override
    public int insert(UserInfo record) {
        return insert("insert", record);
    }

    @Override
    public UserInfo getById(Integer id) {
        return selectOne("getById", id);
    }

    @Override
    public int updateById(UserInfo record) {
        return update("updateById", record);
    }

    @Override
    public List<UserInfo> getAvatarListByUserIdList(List<Integer> userIds) {
        Map<String, Object> params = new HashMap<>();
        params.put("userIds", userIds);
        return selectList("getAvatarListByUserIdList", params);
    }

    @Override
    public UserInfo getByEmail(String email) {
        return selectOne("getByEmail", email);
    }

    @Override
    public UserInfo getByEmailPassword(String email, String password) {
        Map<String, Object> params = new HashMap<>();
        params.put("email", email);
        params.put("password", params);
        return selectOne("getByEmailPassword", params);
    }
}

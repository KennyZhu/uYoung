package com.uyoung.core.api.service.impl;

import com.uyoung.core.api.dao.UserInfoDao;
import com.uyoung.core.api.model.UserInfo;
import com.uyoung.core.api.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public int add(UserInfo userInfo) {
        if (userInfo == null) {
            return 0;
        }
        return userInfoDao.insert(userInfo);
    }

    @Override
    public UserInfo getById(int userId) {
        return userInfoDao.getById(userId);
    }
}
